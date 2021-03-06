package solv.fact.service.survey;

import solv.fact.service.question.model.QuestionFullResponse;
import solv.fact.service.question.model.QuestionRequest;
import solv.fact.service.survey.model.*;

import java.util.List;

public interface SurveyService {
    SurveyFullResponse updateSurvey(int id, SurveyRequestPull requested);
    int createSurvey(SurveyRequest requested);
    void deleteSurvey(int id);
    List findAllActiveSurvey();

    int createQuestionAtSurvey(int surveyId, QuestionRequest requested);
    QuestionFullResponse updateQuestionAtSurvey(int surveyId, int questionId, QuestionRequest requested);
    void deleteQuestionAtSurvey(int surveyId, int questionId);
}
