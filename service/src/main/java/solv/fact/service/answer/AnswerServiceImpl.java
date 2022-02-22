package solv.fact.service.answer;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import solv.fact.repository.AnswerRepository;
import solv.fact.service.answer.model.AnswerFullResponse;
import solv.fact.service.answer.model.AnswerHelper;
import solv.fact.service.answer.model.AnswerValueTextEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public void create(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            Map<String, String>[] requested ) {
        AnswerValueTextEnum category = AnswerHelper.categoryOrOther(requested)
                .orElseThrow(() -> new IllegalArgumentException("Empty request answer not created"));
        switch (category) {
            case UNKNOWN:
                throw new IllegalArgumentException("Not consistent request answer not created");
            default:
                List<String> requestModel = new ArrayList<>();
//                requestModel.
//                answerRepository.createAnswer(surveyId, questionId, personId, category, List<String>);
                throw new NotImplementedException("Answer service method not implemented");
        }
    }

    @Override
    public AnswerFullResponse findAllByPersonId(Integer personId) {
        throw new NotImplementedException("Answer service method not implemented");
    }

}
