package solv.fact.repository.answer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import solv.fact.repository.entity.Answer;

import java.util.List;

public interface CustomAnswerSpecialQueryRepository extends CrudRepository<Answer, Integer> {
    @Query("select a from Answer as a where u.participation_id = :participationId")
    List<Answer> _findAllById(@Param("participationId") int participationId);

    int _createAnswerParticipationReturnId(Integer surveyId, Integer questionId, Integer personId);

    // https://www.baeldung.com/spring-data-jpa-query
    @Query(value =
            "INSERT INTO answer (text_answer, participation_id) \n" +
            "     VALUES (:textAnswer, :participationId)",
            nativeQuery = true)
    void _createAnswerTextWithParticipationId(
            @Param("textAnswer") String text_answer,
            @Param("participationId") int participation_id );


}
