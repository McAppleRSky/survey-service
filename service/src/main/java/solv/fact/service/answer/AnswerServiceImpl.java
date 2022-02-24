package solv.fact.service.answer;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import solv.fact.repository.AnswerRepository;
import solv.fact.repository.entity.Participation;
import solv.fact.service.answer.model.AnswerFullResponse;
import solv.fact.service.answer.model.AnswerHelper;
import solv.fact.service.answer.model.AnswerRequest;
import solv.fact.service.answer.model.AnswerValuesOrTextEnum;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Transactional
    @Override
    public void create(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerRequest requested ) {
        int participationId = answerRepository
                .createAnswerParticipation(
                        new Participation(null, surveyId, questionId, personId) );
        AnswerValuesOrTextEnum category = AnswerHelper.categoryOrOther(requested)
                .orElseThrow(() -> new IllegalArgumentException("Not consistent request answer not created"));
        switch (category) {
            case TEXT:
                answerRepository.createAnswerText(participationId, requested);
                break;
            case VALUES:
                answerRepository.createAnswerValues(participationId, requested);
                break;
        }
    }

    @Override
    public AnswerFullResponse findAllByPersonId(Integer personId) {
        throw new NotImplementedException("Answer service method not implemented");
    }

}
