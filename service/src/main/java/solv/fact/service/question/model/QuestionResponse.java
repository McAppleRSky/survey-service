package solv.fact.service.question.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import solv.fact.service.answer.model.AnswerResponse;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionResponse {
        private final String title;
        private final String type;
        private final AnswerResponse answerResponse;
}
