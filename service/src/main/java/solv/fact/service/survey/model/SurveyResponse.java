package solv.fact.service.survey.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import solv.fact.service.question.model.QuestionResponse;

import javax.annotation.Nonnull;
import java.util.List;

@Getter // @Setter
//@AllArgsConstructor
@RequiredArgsConstructor
public class SurveyResponse {

    @Nonnull
    private final String titleSurveys;

    @Nonnull
    private final List<QuestionResponse> questionsResponse;

}
