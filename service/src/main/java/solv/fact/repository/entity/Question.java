package solv.fact.repository.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;

    @Size(min = 5)
    @Column(name = "name_question", length=1024)
    String name;

    @ElementCollection(targetClass = QuestionType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "question_type_id", joinColumns = @JoinColumn(name = "question_id"))
    @Enumerated(EnumType.STRING)
    @Column(name="question_type", length=5)
    private Set<QuestionType> questionType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity=Survey.class)
    @JoinColumn(name="survey_id", nullable=false)
    private Survey survey;

//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Answer answer;

}
