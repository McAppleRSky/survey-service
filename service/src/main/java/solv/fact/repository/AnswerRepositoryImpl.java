package solv.fact.repository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Answer;
import solv.fact.service.answer.model.AnswerValueTextEnum;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Answer> createAnswer(
            Integer surveyId,
            Integer questionId,
            Integer personId,
            AnswerValueTextEnum category,
            Map<String, String>[] requested ) {
        /*StringBuilder stringBuilder = new StringBuilder(
                "INSERT INTO answer (value, text, person_id, survey_id, question_id) \n" +
                "     VALUES (); \n"
        );

        for (Map<String, String> mapStringString : requested) {
            for (AnswerValueTextEnum value : AnswerValueTextEnum.values()) {

            }


        }

        String qlString =
                "INSERT INTO answer (value, text, person_id, survey_id, question_id) \n" +
                "     VALUES (); \n" +
                "     SELECT a from Answer a";
        return entityManager
                .createQuery(qlString, Answer.class).getResultList();*/
        throw new NotImplementedException("Answer repository method not implemented");
    }
}
