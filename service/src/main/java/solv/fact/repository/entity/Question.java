package solv.fact.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

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
    String title;

    @ManyToOne//(fetch = FetchType.EAGER//, targetEntity=Survey.class)
    @JoinColumn(name="qvariant_id", nullable=false)
    private Survey survey;

    //    @Enumerated(EnumType.ORDINAL)
//    @Enumerated(EnumType.STRING)
    @ManyToOne//(fetch = FetchType.EAGER//, targetEntity=QuestionType.class)
    @JoinColumn(name="qtype_id", nullable = false)
    private QuestionType questionType;

    /*@ElementCollection(targetClass = QuestionType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "qtype", joinColumns = @JoinColumn(name = "question_id"))
    @Enumerated(EnumType.STRING)
    @Column(name="question_type", length=5)
    private Set<QuestionType> questionType;*/

    @OneToMany(
//            mappedBy = "question",
            cascade = CascadeType.ALL
//            ,orphanRemoval = true
//            ,fetch = FetchType.EAGER
    )
    private Collection<QuestionVariant> questionVariants;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Answer> answers;

}
