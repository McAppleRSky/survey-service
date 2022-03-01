package solv.fact.service.answer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class AnswerResponse {

    @Nullable
    private final String text;

    @Nonnull
    private final List<String> values;

}
