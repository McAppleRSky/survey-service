package solv.fact.service.question.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class QuestionRequest {
    String name;
    QuestionType type;
}
