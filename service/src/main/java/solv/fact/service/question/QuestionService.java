package solv.fact.service.question;

import solv.fact.service.question.model.QuestionRequest;
import solv.fact.service.question.model.QuestionResponse;

public interface QuestionService {
    int createQuestion(Integer surveyId, QuestionRequest requested);
    QuestionResponse updateQuestion(Integer surveyId, Integer questionId, QuestionRequest requested);
    void deleteQuestion(Integer surveyId, Integer questionId);
}
