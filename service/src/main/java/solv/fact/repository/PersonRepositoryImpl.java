package solv.fact.repository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Person;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Nullable
    @Override
    public Person findById(@Nonnull Integer integer) {
        throw new NotImplementedException("findById not impl");
    }

    @Nonnull
    @Override
    public List<Person> findAll() {
        throw new NotImplementedException("findAll not impl");
    }

    @Nonnull
    @Override
    public Person update(@Nonnull Person entity) {
        throw new NotImplementedException("update not impl");
    }

    @Nullable
    @Override
    public Person delete(@Nonnull Integer integer) {
        throw new NotImplementedException("delete not impl");
    }

    @Nonnull
    @Override
    public Person save(@Nonnull Person entity) {
        throw new NotImplementedException("save not impl");
    }

}
