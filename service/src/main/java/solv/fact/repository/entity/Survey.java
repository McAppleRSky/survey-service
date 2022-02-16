package solv.fact.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Integer id;

    @Size(min = 5)
    @Column(name = "title_survey", length=1024)
    String title;

    @Column(name = "start_survey")
    private Timestamp start;

    @Column(name = "finish_survey")
    private Timestamp finish;

    @Size(min = 5)
    @Column(name = "description_survey", length=4096)
    String description;

//    @OneToMany(mappedBy="survey", fetch= FetchType.EAGER, orphanRemoval=true, cascade=CascadeType.ALL)
//    private Set<Question> question;

}
