package solv.fact.repository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Question;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Nullable
    @Override
    public Question findById(@Nonnull Integer integer) {
        throw new NotImplementedException("findById not impl");
    }

    @Nonnull
    @Override
    public List<Question> findAll() {
        throw new NotImplementedException("findAll not impl");
    }

    @Nonnull
    @Override
    public Question update(@Nonnull Question entity) {
        throw new NotImplementedException("update not impl");
    }

    @Nullable
    @Override
    public Question delete(@Nonnull Integer integer) {
        throw new NotImplementedException("delete not impl");
    }

    @Nonnull
    @Override
    public Question save(@Nonnull Question entity) {
        throw new NotImplementedException("save not impl");
    }

}
