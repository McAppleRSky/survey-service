package solv.fact.service.question.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QuestionType {

    TEXT("text"),
    CHECK("check"),
    RADIO("radio");

    private final String type;

}
