package solv.fact.repository;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Answer;
import solv.fact.repository.entity.Participation;
import solv.fact.service.answer.model.AnswerRequest;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository
{

    @PersistenceContext
    private EntityManager entityManager;

//    private static Logger LOGGER = LoggerFactory.getLogger(AnswerRepositoryImpl.class);

    @Override
    public int createAnswerParticipationReturnId(Integer surveyId, Integer questionId, Integer personId) {
        Participation participation = new Participation(null, surveyId, questionId, personId);
        entityManager.persist(participation);
        return participation.getId();
    }

    @Override
    public int createAnswerValues(String[] values, int participationCreatedId) {
        StringBuilder qlBuilder = new StringBuilder(
                "INSERT INTO answer (value_answer, participation_id) \n" +
                "     VALUES " );
        for (int i = 0; i < values.length; i++) {
            if (i != 0) {
                qlBuilder.append(", \n            ");
            }
            qlBuilder.append("('" + values[i] + "', " + participationCreatedId + ")");
        }
//        LOGGER.info("create query : \n" + qlBuilder);
        Query query = entityManager.createNativeQuery(qlBuilder.toString());
        return query.executeUpdate();
    }

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
    public Answer save(@Nonnull Answer created) {
        entityManager.persist(created);
        return created;
    }

}
