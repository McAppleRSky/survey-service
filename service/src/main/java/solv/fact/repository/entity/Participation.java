package solv.fact.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participation_id")
    private Integer id;

    @Column(name = "survey_id", nullable = false)
    private Integer surveyId;

    @Column(name = "question_id", nullable = false)
    private Integer questionId;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

//    @ManyToOne @JoinColumn(name = "question_id", nullable = false) private Question question;

}
