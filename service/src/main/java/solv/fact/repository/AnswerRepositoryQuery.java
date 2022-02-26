package solv.fact.repository;

import org.springframework.data.domain.Sort;
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

}
