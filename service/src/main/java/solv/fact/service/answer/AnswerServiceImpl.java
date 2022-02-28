package solv.fact.service.answer;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import solv.fact.repository.AnswerRepository;
import solv.fact.repository.AnswerRepositoryQuery;
import solv.fact.service.answer.model.AnswerFullResponse;
import solv.fact.service.answer.model.AnswerHelper;
import solv.fact.service.answer.model.AnswerRequest;
import solv.fact.service.answer.model.AnswerValuesOrTextEnum;

import javax.transaction.Transactional;
import java.util.List;

import static solv.fact.service.answer.model.AnswerHelper.createAnswerFullResponse;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    private final AnswerRepositoryQuery answerRepositoryQuery;

    @Transactional
    @Override
    public void create(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerRequest requested ) {
        AnswerValuesOrTextEnum category = AnswerHelper.categoryOrOther(requested)
                .orElseThrow(() -> new IllegalArgumentException("Not consistent request answer not created"));
        int participationCreatedId = answerRepository.createAnswerParticipationReturnId(
                        surveyId,
                        questionId,
                        personId );
        switch (category) {
            case TEXT:
                answerRepositoryQuery.createAnswerText(requested.getText(), participationCreatedId);
                break;
            case VALUES:
                answerRepository.createAnswerValues(requested.getValues(), participationCreatedId);
                break;
        }
    }

    @Transactional
    @Override
    public List<AnswerFullResponse> findAllByPersonId(Integer personId) {
        return createAnswerFullResponse(answerRepositoryQuery.findAllByPersonId(personId));
    }

}
