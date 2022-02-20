package solv.fact.service.question.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import solv.fact.service.survey.model.QuestionTypeModel;

@Getter
@RequiredArgsConstructor
public class QuestionResponse {
        String name;
        QuestionTypeModel type;
}
