package solv.fact.repository;

import org.springframework.data.repository.NoRepositoryBean;
import solv.fact.repository.IDao;
import solv.fact.repository.entity.Question;

@NoRepositoryBean
public interface QuestionRepository extends IDao<Question, Integer> {
}
