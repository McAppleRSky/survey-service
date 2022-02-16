package solv.fact.service.answer;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import solv.fact.repository.AnswerRepository;
import solv.fact.service.answer.model.AnswerFullResponse;
import solv.fact.service.answer.model.AnswerRequest;

@AllArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public void create(Integer surveyId, Integer questionId, Integer personId, AnswerRequest requested) {
        throw new NotImplementedException("Answer service method not implemented");
    }

    @Override
    public AnswerFullResponse findAllByPersonId(Integer personId) {
        throw new NotImplementedException("Answer service method not implemented");
    }

}
