package solv.fact.service.survey.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;
import java.util.List;

@Getter // @Setter
//@AllArgsConstructor
@RequiredArgsConstructor
public class SurveysResponse {

    @Nonnull
    private final String titleSurveys;

    @Nonnull
    private final List<QuestionResponse> questionResponse;

}
