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
    @Column(name = "name_answer", nullable = false, length=16)
    private String name;

    @Size(min = 3, max=1024)
    @Column(name = "text_answer", nullable = false, length=1025)
    private String text;

    @ManyToOne//(fetch = FetchType.EAGER//, targetEntity=QuestionType.class)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

}
