package solv.fact.repository.answer;

import org.springframework.stereotype.Repository;
import solv.fact.service.answer.model.AnswerRequest;

@Repository
public interface ParticioationRepository {

    public int createAnswerText(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerRequest textRequest);

    int createAnswerValues(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerRequest valuesRequest);

}
