package solv.fact.repository;

import org.springframework.data.repository.NoRepositoryBean;
import solv.fact.repository.entity.Person;

@NoRepositoryBean
public interface SurveyRepository extends IDao<Person, Integer> {
}
