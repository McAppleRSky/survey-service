package solv.fact.service.question.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import solv.fact.service.answer.model.AnswerResponse;
import solv.fact.service.question.model.QuestionTypeEnum;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionResponse {
        private final String title;
//        private final QuestionTypeEnum type;
        private final String type;
//        private final List<String[]> questionVariants;
        private final List<AnswerResponse> answersResponse;
}
