package solv.fact.repository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Person;
import solv.fact.repository.entity.Survey;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SurveyRepositoryImpl implements SurveyRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Nullable
    @Override
    public Survey findById(@Nonnull Integer id) {
        return entityManager.find(Survey.class, id);
    }

    @Nonnull
    @Override
    public List<Survey> findAll() {
        return entityManager.createQuery("select s from Survey s", Survey.class).getResultList();
    }

    @Nonnull
    @Override
    public Survey update(@Nonnull Survey entity) {
        return entityManager.merge(entity);
    }

    @Nullable
    @Override
    public Survey delete(@Nonnull Integer id) {
        Survey deleted = entityManager.find(Survey.class, id);
        entityManager.remove(deleted);
        return deleted;
    }

    @Nonnull
    @Override
    public Survey save(@Nonnull Survey created) {
        entityManager.persist(created);
        return created;
    }

}
