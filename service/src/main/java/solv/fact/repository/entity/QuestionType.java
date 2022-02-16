package solv.fact.repository.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;

@Getter
@RequiredArgsConstructor
public enum QuestionType{

    TEXT("text"),
    CHECK("check"),
    RADIO("radio");

    private final String text;

    @Override public String toString() {
        return text;
    }

}
