package solv.fact.service.person.model;

import solv.fact.repository.entity.Person;

public class PersonHelper {

    public static PersonResponse buildResponse(Person person) {
        return new PersonResponse(
                person.getId(),
                person.getName(),
                person.getLogin(),
                person.getPassword(),
                person.getEmail() );
    }

}
