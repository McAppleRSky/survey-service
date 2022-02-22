package solv.fact.service.answer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AnswerRequest {
    private final String text;
    private final String[] values;
}
