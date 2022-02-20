package solv.fact.service.person;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solv.fact.repository.PersonRepository;
import solv.fact.repository.entity.Person;
import solv.fact.service.person.model.PersonResponse;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Transactional(readOnly = true)
    @Override @Nonnull
    public List findAll() {
        throw new NotImplementedException("findAll not impl");
    }

    @Transactional(readOnly = true)
    @Override @Nonnull
    public Object getById(int id) {
        throw new NotImplementedException("getById not impl");
    }

    @Transactional
    @Override @Nonnull
    public Object create(@Nonnull Object requested) {
        throw new NotImplementedException("create not impl");
    }

    @Transactional
    @Override @Nonnull
    public PersonResponse update(int id, @Nonnull Object requested) {
        throw new NotImplementedException("update not impl");
    }

    @Transactional
    @Override @Nonnull
    public void delete(int id) {
        throw new NotImplementedException("delete not impl");
    }

    @Transactional(readOnly = true)
    @Override  @Nullable
    public Optional<Person> getByLogin(String login) {
        return ofNullable(personRepository.findByLogin(login));
    }

    public Optional<Person> getPrincipalOperator() {
        Object principal = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            principal = authentication.getPrincipal();
        }
        return ofNullable(personRepository.findByLogin(principal.toString()));
    }

}
