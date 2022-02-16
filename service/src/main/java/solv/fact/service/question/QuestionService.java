package solv.fact.service.question;

import solv.fact.service.question.model.QuestionRequest;
import solv.fact.service.question.model.QuestionResponse;

public interface QuestionService {
    int create(Integer surveyId, QuestionRequest requested);
    QuestionResponse update(Integer surveyId, Integer questionId, QuestionRequest requested);
    void delete(Integer surveyId, Integer questionId);
}
