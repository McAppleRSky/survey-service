package solv.fact.repository;

import org.springframework.stereotype.Repository;
import solv.fact.repository.entity.Answer;
import solv.fact.repository.entity.Participation;

@Repository
public interface ParticipationRepository extends IDao<Participation, Integer> {
}
