package solv.fact.service.answer;

import solv.fact.service.answer.model.AnswerFullResponse;

import java.util.Map;

public interface AnswerService {
    void create(Integer surveyId, Integer questionId, Integer personId, Map<String, String>[] requested);
    AnswerFullResponse findAllByPersonId(Integer personId);
}
