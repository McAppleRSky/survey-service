package solv.fact.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import solv.fact.repository.entity.Answer;
import solv.fact.service.answer.model.AnswerRequest;
import solv.fact.service.answer.model.AnswerValuesOrTextEnum;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface AnswerRepository extends IDao<Answer, Integer> {

    int createAnswerText(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerRequest textRequest);

    @Modifying
    @Query("update User u set u.firstname = ?1 where u.lastname = ?2")
    int createAnswerText1(
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
