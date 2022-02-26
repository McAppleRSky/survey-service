package solv.fact.repository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Answer;
import solv.fact.repository.entity.Participation;
import solv.fact.repository.entity.Survey;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ParticipationRepositoryImpl implements ParticipationRepository
{

    @PersistenceContext
    private EntityManager entityManager;

    @Nullable
    @Override
    public Participation findById(@Nonnull Integer id) {
        return entityManager.find(Participation.class, id);
    }

    @Nonnull
    @Override
    public List<Participation> findAll() {
        throw new NotImplementedException("findAll not impl");
    }

    @Nonnull
    @Override
    public Participation update(@Nonnull Participation entity) {
        throw new NotImplementedException("update not impl");
    }

    @Nullable
    @Override
    public Participation delete(@Nonnull Integer integer) {
        throw new NotImplementedException("delete not impl");
    }

    @Nonnull
    @Override
    public Participation save(@Nonnull Participation entity) {
        throw new NotImplementedException("save not impl");
    }

}
