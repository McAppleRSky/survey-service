package solv.fact.service.answer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Getter
@RequiredArgsConstructor
public class AnswerResponse {

    @Nullable
    private final String text;

    @Nonnull
    private final String[] values;

}
