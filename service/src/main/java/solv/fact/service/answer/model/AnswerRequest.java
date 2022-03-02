package solv.fact.service.answer.model;

import lombok.*;

import javax.annotation.Nullable;

@Getter @Setter
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {
    @Nullable
    private String text;
    @Nullable
    private String[] values;
}
