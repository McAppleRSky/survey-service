package solv.fact.service.survey.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionResponse {
        private final String title;
        private final QuestionTypeEnum type;
        private final List<String[]> questionVariants;
}
