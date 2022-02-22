package solv.fact.service.answer.model;

import javax.annotation.Nonnull;
import java.util.*;

public class AnswerHelper {

    @Nonnull
    private static Map<AnswerValuesOrTextEnum, Object> toModel(@Nonnull Map<String, Object> requested) {
        Map<AnswerValuesOrTextEnum, Object> result = new HashMap<>();
        AnswerValuesOrTextEnum[] values = AnswerValuesOrTextEnum.values();
        if (values.length != requested.size()) {
            throw new IllegalArgumentException("requested size not 2");
        }
        for (String key : requested.keySet()) {
            for (AnswerValuesOrTextEnum enumValue : values) {
                if (key.equals(enumValue.getValue())) {
                    result.put(enumValue, requested.get(key));
                }
            }
        }
        if (values.length != result.size()) {
            throw new IllegalArgumentException("model from requested size not 2");
        }
        if (result.get(AnswerValuesOrTextEnum.TEXT).getClass().getName() != "String") {
            throw new IllegalArgumentException(" requested text not String");
        }
        if (result.get(AnswerValuesOrTextEnum.VALUES).getClass().getName() != "List") {
            throw new IllegalArgumentException(" requested text not List");
        }



        for (Map<String, String> mapStringString : requested) {
            for (String requestKey : mapStringString.keySet()) {
                if (requestKey.equals(AnswerValuesOrTextEnum.TEXT.getCategory())) {
                    textCount++;
                }
                if (requestKey.equals(AnswerValuesOrTextEnum.VALUE.getCategory())) {
                    valueCount++;
                }
            }
        }
        if (textCount == 1 ^ valueCount > 0) {
            if (textCount == 1) {
                return AnswerValuesOrTextEnum.TEXT;
            } else {
                return AnswerValuesOrTextEnum.VALUE;
            }
        } else {
            return AnswerValuesOrTextEnum.UNKNOWN;
        }
        return null;
    }

    @Nonnull
    public static Optional<AnswerValuesOrTextEnum> categoryOrOther(@Nonnull Map requested) {
        return null
//                Optional
//                .of(requested.length == 0 ? null : readCategory(requested))
                ;
    }

}
