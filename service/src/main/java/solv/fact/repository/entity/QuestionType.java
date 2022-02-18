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
@Entity(name="qtype")
public class QuestionType{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qtype_id")
    private Integer id;

    @Size(min = 4, max=5)
    @Column(name = "name_qtype", nullable = false, length=5)
    private String name;

    @OneToMany//(
//            mappedBy = "question",
//            cascade = CascadeType.ALL
//            ,orphanRemoval = true
//            ,fetch = FetchType.EAGER)
    private Collection<Question> questions;

}
