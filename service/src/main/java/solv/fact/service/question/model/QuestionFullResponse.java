package solv.fact.service.question.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionFullResponse {
        private final String title;
        private final QuestionTypeEnum type;
        private final List<String[]> questionVariants;
}
