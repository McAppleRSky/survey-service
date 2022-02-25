package solv.fact.repository;

import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Answer;
import solv.fact.service.answer.model.AnswerRequest;

//@NoRepositoryBean
@Repository
public interface AnswerRepository extends IDao<Answer, Integer> {

}
