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
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer id;

    @Size(min = 3, max=16)
    @Column(name = "value_answer", length=16)
    private String value;

    @Size(min = 3, max=1024)
    @Column(name = "text_answer", length=1025)
    private String text;

    @Column(name = "participation_id", nullable = false)
    private Integer questionId;
//    @ManyToOne @JoinColumn(name = "question_id", nullable = false) private Question question;

}
