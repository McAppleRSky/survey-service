package solv.fact.service.question.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import solv.fact.service.survey.model.QuestionTypeModel;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionRequest {
    String title;
    QuestionTypeModel type;
    List<String[]> questionVariants;
}
