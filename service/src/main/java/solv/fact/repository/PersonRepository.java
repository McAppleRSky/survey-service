package solv.fact.repository;

import org.springframework.data.repository.NoRepositoryBean;
import solv.fact.repository.entity.Answer;
import solv.fact.repository.entity.Person;

@NoRepositoryBean
public interface PersonRepository extends IDao<Person, Integer> {
}
