package solv.fact.service.answer;

import solv.fact.service.answer.model.AnswerFullResponse;
import solv.fact.service.answer.model.AnswerRequest;

import java.util.List;
import java.util.Map;

public interface AnswerService {
    void create(Integer surveyId, Integer questionId, Integer personId, AnswerRequest requested);
    List<AnswerFullResponse> findAllByPersonId(Integer personId);
}
