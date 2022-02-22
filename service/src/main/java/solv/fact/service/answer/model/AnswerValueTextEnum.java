package solv.fact.service.answer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AnswerValueTextEnum {

    VALUE("value"),
    VALUES("values"),
    TEXT("text"),
    UNKNOWN("unknown");

    private final String category;

}
