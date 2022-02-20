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
@Entity(name="qvariant")
public class QuestionVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qvariant_id")
    private Integer id;

    @Size(min = 3, max=16)
    @Column(name = "title_qvariant", nullable = false, length=16)
    private String title;

    @Size(min = 5, max=128)
    @Column(name = "value_qvariant", nullable = false, length=16)
    private String value;

    @ManyToOne//(fetch = FetchType.EAGER//, targetEntity=QuestionType.class)
//    @OneToMany(mappedBy = "Answer")
    @JoinColumn(name = "answer_id", nullable = false)
    private Question question;

}
