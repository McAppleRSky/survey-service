package solv.fact.repository.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer id;

    @Size(min = 5)
    @Column(name = "name_answer", length=1024)
    String name;

//    @MapsId
    @OneToOne(mappedBy = "Answer")
    @JoinColumn(name = "answer_id")
    private Question question;

    @Column(name = "is_correct", length=1024)
    Boolean isCorrect;

//    @ManyToOne(fetch = FetchType.EAGER, targetEntity=Person.class)
//    @JoinColumn(name="person_id", nullable=false)
//    private Person person;

}
