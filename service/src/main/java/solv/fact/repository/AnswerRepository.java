package solv.fact.repository;

import org.springframework.data.repository.NoRepositoryBean;
import solv.fact.repository.entity.Answer;

@NoRepositoryBean
public interface AnswerRepository extends IDao<Answer, Integer> {
}
