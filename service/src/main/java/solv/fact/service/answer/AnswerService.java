package solv.fact.service.answer;

import solv.fact.service.answer.model.AnswerFullResponse;
import solv.fact.service.answer.model.AnswerRequest;

import java.util.Map;

public interface AnswerService {
    void create(Integer surveyId, Integer questionId, Integer personId, Map requested);
    AnswerFullResponse findAllByPersonId(Integer personId);
}
