package solv.fact.service.answer;

import org.apache.commons.lang3.NotImplementedException;
import solv.fact.service.answer.model.AnswerFullResponse;
import solv.fact.service.answer.model.AnswerRequest;

public class AnswerServiceImpl implements AnswerService {

    @Override
    public void create(Integer surveyId, Integer questionId, Integer personId, AnswerRequest requested) {
        throw new NotImplementedException("Answer service method not implemented");
    }

    @Override
    public AnswerFullResponse findAllByPersonId(Integer personId) {
        throw new NotImplementedException("Answer service method not implemented");
    }

}
