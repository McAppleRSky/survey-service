package solv.fact.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Integer id;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Column(name = "qestion_id", nullable = false)
    private Integer qestionId;

    @Column(name = "answer_id", nullable = false)
    private Integer answerId;

}
