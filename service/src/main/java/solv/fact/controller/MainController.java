package solv.fact.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import solv.fact.repository.entity.Question;
import solv.fact.repository.entity.Survey;
import solv.fact.service.answer.AnswerService;
import solv.fact.service.answer.model.AnswerTuple;
import solv.fact.service.answer.model.AnswerRequest;
import solv.fact.service.question.model.QuestionRequest;
import solv.fact.service.question.model.QuestionFullResponse;
import solv.fact.service.survey.SurveyService;
import solv.fact.service.survey.model.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/0.0.1/surveys")
@RequiredArgsConstructor
public class MainController implements SurveyServletable, QuestionServletable, PassingServletable {

    private final SurveyService surveyService;
    private final AnswerService answerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Void> surveyCreate(@Valid @RequestBody SurveyRequest requested) {
        final int id = surveyService.createSurvey(requested);
        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/0.0.1/surveys/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Survey> surveyUpdate(@PathVariable Integer id, @Valid @RequestBody SurveyRequestPull requested) {
        SurveyFullResponse updated = surveyService.updateSurvey(id, requested);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-store, no-cache, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        return new ResponseEntity(updated, headers, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Override
    public void surveyDelete(Integer id) {
        surveyService.deleteSurvey(id);
    }

    @PostMapping(value = "/{id}/question", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Void> questionCreate(@PathVariable Integer surveyId, @Valid @RequestBody QuestionRequest requested) {
        Map<String, Object> params = new HashMap<>();
        params.put("survey_id", surveyId);
        final int questionId = surveyService.createQuestionAtSurvey(surveyId, requested);
        params.put("question_id", questionId);
        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/0.0.1/survey/{survey_id}/question/{question_id}")
                .buildAndExpand(questionId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PatchMapping(value = "/{surveyId}/question/{questionId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Question> questionUpdate(
            @PathVariable Integer surveyId,
            @PathVariable Integer questionId,
            @Valid @RequestBody QuestionRequest requested ) {
        QuestionFullResponse updated = surveyService.updateQuestionAtSurvey(surveyId, questionId, requested);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-store, no-cache, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        return new ResponseEntity(updated, headers, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{surveyId}/question/{questionId}")
    @Override
    public void questionDelete(
            @PathVariable Integer surveyId,
            @PathVariable Integer questionId ) {
        surveyService.deleteQuestionAtSurvey(surveyId, questionId);
    }

    @GetMapping(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SurveyFullResponse> surveys() {
        return surveyService.findAllActiveSurvey();
    }

    @PostMapping(value = "/{surveyId}/answer/{questionId}/user/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Void> answerCreate(
                @PathVariable Integer surveyId,
                @PathVariable Integer questionId,
                @PathVariable Integer personId,
                @Valid @RequestBody AnswerRequest requested ) {
        Map<String, Object> params = new HashMap<>();
        params.put("survey_id", surveyId);
        params.put("personId", personId);
        answerService.create(surveyId, questionId, personId, requested);
        params.put("question_id", questionId);
        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/0.0.1/survey/{survey_id}/answer/{question_id}")
                .buildAndExpand(questionId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/answer/user/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnswerTuple> answer(@PathVariable Integer personId) {
        return answerService.findAllByPersonId(personId);
    }

}

interface SurveyServletable {
    ResponseEntity
        surveyCreate(SurveyRequest requested);
    ResponseEntity
        surveyUpdate(Integer id, SurveyRequestPull requested);
    void
        surveyDelete(Integer id);
}

interface QuestionServletable {
    ResponseEntity
        questionCreate(Integer id, QuestionRequest requested);
    ResponseEntity
        questionUpdate(
            Integer surveyId,
            Integer questionId,
            QuestionRequest requested );
    void
        questionDelete(Integer surveyId, Integer questionId);
}

interface PassingServletable {
    List
        surveys();
    ResponseEntity
        answerCreate(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerRequest requested );
    Object
        answer(Integer personId);
}
