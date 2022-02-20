package solv.fact.service.survey;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solv.fact.repository.SurveyRepository;
import solv.fact.repository.entity.Question;
import solv.fact.repository.entity.Survey;
import solv.fact.service.question.model.QuestionRequest;
import solv.fact.service.question.model.QuestionResponse;
import solv.fact.service.survey.model.*;

import javax.annotation.Nonnull;
import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.Optional.ofNullable;

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
                                .map(updating -> ModelHelper.updateSurveyPullEntity(
                                        updating, requested))
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

    @Override
    public SurveysFullResponse findAllActiveSurvey() {
        throw new NotImplementedException("Survey service method not implemented");
    }

    @Transactional
    @Override
    public int createQuestionAtSurvey(int surveyId, QuestionRequest requested) {
        Survey atSurvey = ofNullable(surveyRepository.findById(surveyId))
                .orElseThrow(() -> new EntityNotFoundException("Survey '" + surveyId + "' not found"));
        List<Question> questions = atSurvey.getQuestions();
        questions.add(ModelHelper.createQuestionEntity(requested));
        Survey save = surveyRepository.save(atSurvey);

        return atSurvey.;
    }

    @Override
    public QuestionResponse updateQuestion(int surveyId, int questionId, QuestionRequest requested) {
        return null;
    }

    @Override
    public void deleteQuestion(int surveyId, int questionId) {

    }

}
