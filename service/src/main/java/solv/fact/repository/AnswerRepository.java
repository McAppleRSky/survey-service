package solv.fact.repository;

import org.springframework.data.repository.NoRepositoryBean;
import solv.fact.repository.entity.Answer;
import solv.fact.service.answer.model.AnswerValueTextEnum;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface AnswerRepository extends IDao<Answer, Integer> {

    List createAnswer(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerValueTextEnum category,
            Map<String, String>[] requested );

}
