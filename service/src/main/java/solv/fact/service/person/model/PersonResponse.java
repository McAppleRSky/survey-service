package solv.fact.service.person.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//@Data
//@Accessors(chain = true)
@Getter
@RequiredArgsConstructor
public class PersonResponse {

    private final Integer id;
    private final String name;
    private final String login;
    private final String password;
    private final String email;

}
