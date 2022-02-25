package solv.fact.service.answer;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
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
        AnswerValuesOrTextEnum category = AnswerHelper.categoryOrOther(requested)
                .orElseThrow(() -> new IllegalArgumentException("Not consistent request answer not created"));
        int participationCreatedId = createAnswerParticipationReturnId(
                surveyId,
                questionId,
                personId);

        switch (category) {
            case TEXT:
                answerRepository.createAnswerText(surveyId, questionId, personId, requested);
                break;
            case VALUES:
                answerRepository.createAnswerValues(surveyId, questionId, personId, requested);
                break;
        }
    }

    @Override
    public AnswerFullResponse findAllByPersonId(Integer personId) {
        throw new NotImplementedException("Answer service method not implemented");
    }

}
