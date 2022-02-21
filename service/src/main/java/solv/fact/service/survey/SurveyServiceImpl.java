package solv.fact.service.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solv.fact.repository.SurveyRepository;
import solv.fact.repository.entity.Question;
import solv.fact.repository.entity.Survey;
import solv.fact.service.survey.model.*;

import javax.annotation.Nonnull;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    @Transactional
    @Override
    public int createSurvey(@Nonnull SurveyRequest requested) {
        Survey creating = ModelHelper.createSurveyPullEntity(requested);
        Survey created = surveyRepository.save(creating);
        return created.getId();
    }

    @Nonnull
    @Override
    @Transactional
    public SurveyResponse updateSurvey(int id, @Nonnull SurveyRequestPull requested) {
//        final SurveyRequestPull requestedFinal = requested;
        /*Survey updating = surveyRepository.findById(id);
        if (updating==null){
            throw new EntityNotFoundException("Survey '" + id + "' not found");
        } else {
            SurveyHelper.updatePullEntity(updating, requested);
            surveyRepository.update(updating);
        }*/
        return ModelHelper.createSurveyResponse(
                surveyRepository.update(
                        ofNullable(surveyRepository.findById(id))
                                .map(updating -> ModelHelper.updateSurveyPullEntity(updating, requested))
                                .orElseThrow(() -> new EntityNotFoundException("Survey '" + id + "' not found")) ) );
    }

    @Transactional(readOnly = true)
    @Nonnull
    SurveyResponse getById(int id) {
        return ofNullable(surveyRepository.findById(id))
                .map(ModelHelper::createSurveyResponse)
                .orElseThrow(() -> new EntityNotFoundException("Survey '" + id + "' not found"));
    }

    @Override
    public void deleteSurvey(int id) {
        surveyRepository.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SurveyResponse> findAllActiveSurvey() {
        LocalDateTime now = LocalDateTime.now();
        Comparator<LocalDateTime> nowBetween = (o1, o2) -> o1.isAfter(now) ? -1 : o2.isBefore(now) ? 1 : 0;

        return surveyRepository.findAll().stream()
                .filter(s -> 0 == nowBetween.compare(s.getStart().toLocalDateTime(), s.getFinish().toLocalDateTime()))
                .map(ModelHelper::createSurveyResponse)
                .collect(toList())
                ;
//        return null;
    }

    @Transactional
    @Override
    public int createQuestionAtSurvey(int surveyId, QuestionRequest requested) {
        Survey atSurvey = ofNullable(surveyRepository.findById(surveyId))
                .orElseThrow(() -> new EntityNotFoundException("Survey '" + surveyId + "' not found"));
        List<Question> questions = atSurvey.getQuestions();
        Question questionEntity = ModelHelper.updateQuestionEntityOrCreateIfNull(null, requested);
        questions.add(questionEntity);
//        Survey save =
                surveyRepository.save(atSurvey);
        return questionEntity.getId();
    }

    @Transactional
    @Override
    public QuestionResponse updateQuestionAtSurvey(int surveyId, int questionId, QuestionRequest requestedModel) {
        Survey atSurvey = ofNullable(surveyRepository.findById(surveyId))
                .orElseThrow(() -> new EntityNotFoundException("Survey '" + surveyId + "' not found"));
        Question questionEntity = atSurvey.getQuestions().stream()
                .filter(q -> questionId == q.getId())
                .findAny()
                .orElseThrow(() -> new EntityNotFoundException("Question '" + questionId + "' not found"));
        questionEntity = ModelHelper.updateQuestionEntityOrCreateIfNull(questionEntity, requestedModel);
        surveyRepository.save(atSurvey);
        return ModelHelper.questionResponse(questionEntity);
    }

    @Transactional
    @Override
    public void deleteQuestionAtSurvey(int surveyId, int questionId) {
        Survey atSurvey = ofNullable(surveyRepository.findById(surveyId))
                .orElseThrow(() -> new EntityNotFoundException("Survey '" + surveyId + "' not found"));
        if ( !atSurvey.getQuestions().removeIf(q -> questionId == q.getId()) ) {
            throw new IllegalArgumentException("nothing delete from survey questions");
        }
        surveyRepository.save(atSurvey);
    }

}
