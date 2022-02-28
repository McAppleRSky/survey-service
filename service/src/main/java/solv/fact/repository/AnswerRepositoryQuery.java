package solv.fact.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Answer;

import java.util.List;

// https://www.baeldung.com/spring-data-jpa-query
@Repository
public interface AnswerRepositoryQuery extends CrudRepository<Answer, Integer> {

    @Query("SELECT a FROM Answer a WHERE a.participationId = :participationId")
    List<Answer> findAnswerById(
            @Param("participationId") Integer participationId );

    @Modifying
    @Query(value =
            "INSERT INTO answer (text_answer, participation_id) \n" +
            "     VALUES (:textAnswer, :participationId)",
            nativeQuery = true)
    void createAnswerText(
            @Param("textAnswer") String text_answer,
            @Param("participationId") Integer participation_id );

    @Query(value =
            "SELECT s.title_survey, q.title_question, q.type_question, a.value_answer, a.text_answer \n" +
            "  FROM participation p JOIN survey s ON p.survey_id = s.survey_id \n" +
            "  JOIN question q ON p.question_id = q.question_id \n" +
            "  JOIN answer a ON p.participation_id = a.participation_id \n" +
            " WHERE p.person_id = :personId ",
            nativeQuery = true)
    List<Object[]> findAllByPersonId(@Param("personId") Integer personId);

}
