package solv.fact.service.answer;

import solv.fact.service.answer.model.AnswerTuple;
import solv.fact.service.answer.model.AnswerRequest;

import java.util.List;

public interface AnswerService {
    void create(Integer surveyId, Integer questionId, Integer personId, AnswerRequest requested);
    List<AnswerTuple> findAllByPersonId(Integer personId);
}
