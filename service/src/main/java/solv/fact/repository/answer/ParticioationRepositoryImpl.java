package solv.fact.repository.answer;

import solv.fact.repository.entity.Participation;
import solv.fact.service.answer.model.AnswerRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ParticioationRepositoryImpl implements ParticioationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    int createAnswerParticipationReturnId(Integer surveyId, Integer questionId, Integer personId) {
        Participation participation = new Participation(null, surveyId, questionId, personId);
        entityManager.persist(participation);
        return participation.getId();
    }

    @Override
    public int createAnswerText(Integer surveyId, Integer questionId, Integer personId, AnswerRequest textRequest) {

        createAnswerTextWithParticipationId(
                textRequest.getText(),
                participationReturnId );
        return participationReturnId;
    }

    @Override
    public int createAnswerValues(Integer surveyId, Integer questionId, Integer personId, AnswerRequest valuesRequest) {
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
