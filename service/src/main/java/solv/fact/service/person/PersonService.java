package solv.fact.service.person;

import solv.fact.repository.entity.Person;
import solv.fact.service.person.model.PersonRequest;
import solv.fact.service.person.model.PersonResponse;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    @Nonnull
    List findAll();

    @Nonnull
    Object getById(int id);

    Object create(@Nonnull Object requested);

    @Nonnull
    Object update(int id, @Nonnull Object requested);

    void delete(int id);

    Optional<Person> getByLogin(String login);

}
