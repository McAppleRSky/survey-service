package solv.fact.service.survey.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionRequest {
    private final String title;
    private final QuestionTypeModel type;
    private final List<String[]> questionVariants;
}
