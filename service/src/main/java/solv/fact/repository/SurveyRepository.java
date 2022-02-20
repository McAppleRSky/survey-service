package solv.fact.repository;

import org.springframework.data.repository.NoRepositoryBean;
import solv.fact.repository.entity.Person;
import solv.fact.repository.entity.Survey;

@NoRepositoryBean
public interface SurveyRepository extends IDao<Survey, Integer> {
}
