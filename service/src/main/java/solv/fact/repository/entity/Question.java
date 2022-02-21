package solv.fact.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;

    @Size(min = 5, max=1024)
    @Column(name = "name_question", length=1024)
    private String title;

    @ManyToOne//(fetch = FetchType.EAGER//, targetEntity=Survey.class)
    @JoinColumn(name="survey_id", nullable=false)
    private Survey survey;

    @Size(min = 4, max=5)
    @Column(name = "type_question", length=5)
    private String questionType;

    @OneToMany(
//            mappedBy = "question",
            cascade = CascadeType.ALL
//            ,orphanRemoval = true
//            ,fetch = FetchType.EAGER
    )
    private List<QuestionVariant> questionVariants;

//    @OneToMany(cascade = CascadeType.ALL) private List<Answer> answers;

}
