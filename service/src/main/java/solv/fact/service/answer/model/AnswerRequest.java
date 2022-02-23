package solv.fact.service.answer.model;

import lombok.*;

@Getter @Setter
//@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {
    private String text;
    private String[] values;
}
