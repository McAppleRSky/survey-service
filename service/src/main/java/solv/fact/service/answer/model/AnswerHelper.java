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

}
