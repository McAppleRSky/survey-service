package solv.fact.service.person.model;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

//@Data
//@Accessors(chain = true)
@Setter
@RequiredArgsConstructor
public class PersonRequest {

    @NotEmpty(message = "{field.is.empty}")
    private final String name;
    private final String login;
    private final String password;
    private final String email;

}
