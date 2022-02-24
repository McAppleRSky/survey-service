package solv.fact.repository;

import org.springframework.data.repository.NoRepositoryBean;
import solv.fact.repository.entity.Answer;
import solv.fact.repository.entity.Participation;
import solv.fact.service.answer.model.AnswerRequest;

@NoRepositoryBean
public interface AnswerRepository extends IDao<Answer, Integer> {

    int createAnswerParticipation(Participation participation);

    int createAnswerText(int participationId, AnswerRequest textRequest);

    int createAnswerValues(int participationId, AnswerRequest valuesRequest);

}
