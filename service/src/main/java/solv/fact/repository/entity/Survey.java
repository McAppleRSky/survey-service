package solv.fact.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Integer id;

    @Size(min = 5, max=1024)
    @Column(name = "title_survey", unique=true, nullable = false, length=1024)
    private String title;

    @Column(name = "start_survey", nullable = false)
    private Timestamp start;

    @Column(name = "finish_survey", nullable = false)
    private Timestamp finish;

    @Size(min = 5, max=4096)
    @Column(name = "description_survey", length=4096)
    private String description;

    @OneToMany(
//            mappedBy="survey",
//            cascade=CascadeType.ALL,
            orphanRemoval=true
//            ,fetch= FetchType.EAGER
    )
    private List<Question> questions;

}
