package solv.fact.repository;

import org.springframework.data.repository.NoRepositoryBean;
import solv.fact.repository.entity.Person;

import javax.annotation.Nonnull;

@NoRepositoryBean
public interface PersonRepository extends IDao<Person, Integer> {

    Person findByLogin(@Nonnull String login);

}
