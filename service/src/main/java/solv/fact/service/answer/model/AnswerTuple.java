package solv.fact.service.answer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Getter
@RequiredArgsConstructor
public class AnswerTuple {

    @Nonnull
    private final Integer surveyId;
    @Nonnull
    private final String surveyTitle;

    @Nonnull
    private final Integer questionId;
    @Nonnull
    private final String questionTitle;
    @Nonnull
    private final String questionType;

    @Nullable
    private final String answerText;
    @Nullable
    private final String answerValue;

}
