package solv.fact.service.survey.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QuestionTypeEnum {

    TEXT("text"),
    CHECK("check"),
    RADIO("radio");

    private final String text;

}
