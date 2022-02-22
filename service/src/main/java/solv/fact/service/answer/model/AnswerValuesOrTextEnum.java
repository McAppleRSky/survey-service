package solv.fact.service.answer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AnswerValuesOrTextEnum {

    VALUES("values"),
    TEXT("text")
    ;

    private final String value;

}
