package solv.fact.service.survey;

import solv.fact.service.survey.model.SurveyRequest;
import solv.fact.service.survey.model.SurveyRequestPull;
import solv.fact.service.survey.model.SurveyResponse;
import solv.fact.service.survey.model.SurveysFullResponse;
import solv.fact.service.survey.model.QuestionRequest;
import solv.fact.service.survey.model.QuestionResponse;

import java.util.List;

public interface SurveyService {
    SurveyResponse updateSurvey(int id, SurveyRequestPull requested);
    int createSurvey(SurveyRequest requested);
    void deleteSurvey(int id);
    List findAllActiveSurvey();

    int createQuestionAtSurvey(int surveyId, QuestionRequest requested);
    QuestionResponse updateQuestionAtSurvey(int surveyId, int questionId, QuestionRequest requested);
    void deleteQuestionAtSurvey(int surveyId, int questionId);
}
