package solv.fact.repository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Answer;
import solv.fact.service.answer.model.AnswerRequest;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository {

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

    @Override
    // https://reflectoring.io/spring-boot-data-jpa-test
    // https://www.baeldung.com/spring-data-jpa-query
    // http://www.h2database.com/h2.pdf
    public int createAnswerText(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerRequest textRequest) {
        String qlString = String.format(
                "INSERT INTO participation (survey_id, question_id, person_id) \n" +
                "     VALUES (:surveyId, :questionId, :personId); \n" +
                "INSERT INTO answer (text_answer, participation_id) \n" +
                "     SELECT '%s', participation_id \n" +
                "       FROM participation \n" +
                "   ORDER BY participation_id DESC \n" +
                "      LIMIT 1;  \n" +
                "  SELECT participation_id \n" +
                "    FROM participation \n" +
                "ORDER BY participation_id DESC \n" +
                "   LIMIT 1 ",
                textRequest.getText());
        Query query = entityManager.createNativeQuery(qlString);
        query.setParameter("surveyId", surveyId);
        query.setParameter("questionId", questionId);
        query.setParameter("personId", personId);
        query.setParameter("text", textRequest.getText());
//        query.e
        BigInteger singleResult = (BigInteger) query.getSingleResult();
        return  0//(Integer)query. .getSingleResult()
        ;
    }

    @Override
    public int createAnswerText1(Integer surveyId, Integer questionId, Integer personId, AnswerRequest textRequest) {
        return 0;
    }

    @Override
    public int createAnswerValues(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerRequest valuesRequest) {
        String qlString =
                "INSERT INTO participation (survey_id, question_id, person_id) \n" +
                "     VALUES (:surveyId, :questionId, :personId); \n" +
                "  SELECT MAX(participation_id) \n" +
                "    FROM participation ";
        Query query = entityManager.createQuery(qlString);
        query.setParameter("surveyId", surveyId);
        query.setParameter("questionId", questionId);
        query.setParameter("personId", personId);
        Integer singleResult = (Integer) query.getSingleResult();

        String[] values = valuesRequest.getValues();
        StringBuilder qlBuilder = new StringBuilder(
                "INSERT INTO answer (value, participation_id) \n" +
                "     VALUES \n"
        );
        for (int i = 0; i < values.length; i++) {
            if (i>0) {
                qlBuilder.append(",");
            }
            qlBuilder.append(
                "            ('?', " + singleResult.toString() + ")");
        }
        query = entityManager.createQuery(qlBuilder.toString());
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i + 1, values[i]);
        }
        query.executeUpdate();
        return singleResult;
    }

}
