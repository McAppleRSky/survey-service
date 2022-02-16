package solv.fact.repository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Answer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Nullable
    @Override
    public Answer findById(@Nonnull Integer id) {
        throw new NotImplementedException("findById not impl");
    }

    @Nonnull
    @Override
    public List<Answer> findAll() {
        throw new NotImplementedException("findAll not impl");
    }

    @Nonnull
    @Override
    public Answer update(@Nonnull Answer entity) {
        throw new NotImplementedException("update not impl");
    }

    @Nullable
    @Override
    public Answer delete(@Nonnull Integer integer) {
        throw new NotImplementedException("delete not impl");
    }

    @Nonnull
    @Override
    public Answer save(@Nonnull Answer entity) {
        throw new NotImplementedException("save not impl");
    }

}
