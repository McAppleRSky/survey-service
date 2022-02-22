package solv.fact.service.answer.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;

public class AnswerHelper {

    @Nonnull
    private static AnswerValueTextEnum readCategory(@Nonnull Map<String, String>[] requested) {
        int textCount = 0;
        int valueCount = 0;
        for (Map<String, String> mapStringString : requested) {
            for (String requestKey : mapStringString.keySet()) {
                if (requestKey.equals(AnswerValueTextEnum.TEXT.getCategory())) {
                    textCount++;
                }
                if (requestKey.equals(AnswerValueTextEnum.VALUE.getCategory())) {
                    valueCount++;
                }
            }
        }
        if (textCount == 1 ^ valueCount > 0) {
            if (textCount == 1) {
                return AnswerValueTextEnum.TEXT;
            } else {
                return AnswerValueTextEnum.VALUE;
            }
        } else {
            return AnswerValueTextEnum.UNKNOWN;
        }
    }

    @Nonnull
    public static Optional<AnswerValueTextEnum> categoryOrOther(@Nonnull Map<String, String>[] requested) {
        return Optional
                .of(requested.length == 0 ? null : readCategory(requested));
    }

}
