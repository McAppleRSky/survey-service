package solv.fact.service.answer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AnswerFullResponse {

    private final String titleSurvey;
    private final String titleQuestion;
    private final String typeQuestion;
    private final String valueAnswer;
    private final String textAnswer;

}
