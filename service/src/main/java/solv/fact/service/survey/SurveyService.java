package solv.fact.service.survey;

import solv.fact.service.survey.model.SurveyRequest;
import solv.fact.service.survey.model.SurveyRequestPull;
import solv.fact.service.survey.model.SurveyResponse;
import solv.fact.service.survey.model.SurveysFullResponse;
import solv.fact.service.question.model.QuestionRequest;
import solv.fact.service.question.model.QuestionResponse;

public interface SurveyService {
    SurveyResponse updateSurvey(int id, SurveyRequestPull requested);
    int createSurvey(SurveyRequest requested);
    void deleteSurvey(int id);
    SurveysFullResponse findAllActiveSurvey();

    int createQuestionAtSurvey(int surveyId, QuestionRequest requested);
    QuestionResponse updateQuestion(int surveyId, int questionId, QuestionRequest requested);
    void deleteQuestion(int surveyId, int questionId);
}
