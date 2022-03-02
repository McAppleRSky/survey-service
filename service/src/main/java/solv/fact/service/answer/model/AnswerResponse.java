package solv.fact.service.answer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@Getter @Setter
//@RequiredArgsConstructor
@AllArgsConstructor
public class AnswerResponse {

    @Nullable
    private String text;

    @Nonnull
    private List<String> values;

}
