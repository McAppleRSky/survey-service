package solv.fact.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person //implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;

    @NotBlank(message = "name cannot be empty")
    @Size(min = 3, max=75)
    @Column(name = "name_person", length=75)
    private String name;

    @NotBlank(message = "login cannot be empty")
    @Size(min = 3, max=32)
    @Column(name = "login_person", unique=true, nullable = false, length=32)
    private String login;

    // TODO refactor pass encode, match
    @NotBlank(message = "password cannot be empty")
    @Size(min=8, max=16)
    @Column(name = "password_person", nullable = false, length=16)
    private String password;

    @Email(message="Email is not correct")
    @NotBlank(message = "email cannot be empty")
    @Size(min=8, max=128)
    @Column(name = "email_person", length=128)
    private String email;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "person_id"))
    @Enumerated(EnumType.STRING)
    @Size(min=4, max=5)
    @Column(length=5)
    private Set<Role> roles;

//    @OneToMany(mappedBy="person", fetch= FetchType.EAGER, orphanRemoval=true, cascade=CascadeType.ALL)
//    private Set<Answer> answers;

}
