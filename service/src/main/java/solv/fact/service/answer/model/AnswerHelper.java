package solv.fact.service.answer.model;

import javax.annotation.Nonnull;
import java.util.*;

import static org.springframework.util.ObjectUtils.isEmpty;

public class AnswerHelper {

    @Nonnull
    public static Optional<AnswerValuesOrTextEnum> categoryOrOther(@Nonnull AnswerRequest requested) {
        boolean notText = isEmpty(requested.getText());
        boolean notValue = requested.getValues().length == 0;
        return Optional.ofNullable(
                !(notText ^ notValue) ? null :
                        notValue ? AnswerValuesOrTextEnum.TEXT :
                                isEmpty(requested.getValues()[0]) ? null : AnswerValuesOrTextEnum.VALUES );
    }

    @Nonnull
    public static List<AnswerFullResponse> createAnswerFullResponse(@Nonnull List<Object[]> tuples) {
        List<AnswerFullResponse> result = new ArrayList<>();
        for (Object[] tuple : tuples) {
            result.add(
                    new AnswerFullResponse(
                            tuple[0].toString(), // s.title_survey
                            tuple[1].toString(),  // q.title_question
                            tuple[2].toString(),   // q.type_question
                            tuple[3].toString(),    // a.value_answer
                            tuple[4].toString() ) ); // a.text_answer
        }
        return result;
    }

}
