package solv.fact.repository;

import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Answer;

@Repository
public interface AnswerRepository extends IDao<Answer, Integer> {

    int createAnswerParticipationReturnId(Integer surveyId, Integer questionId, Integer personId);

    int createAnswerValues(String[] values, int participationCreatedId);

}
