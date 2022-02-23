package solv.fact.service.answer.model;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.*;

class AnswerHelperTest {

    @Test
    void test1() {
        String testText = randomAlphabetic(3);
        String testValue = randomAlphabetic(3);
        Optional<Object> optionalNull = Optional.ofNullable(null);
        assertEquals(
                optionalNull,
                AnswerHelper.categoryOrOther(new AnswerRequest(testText, new String[]{testValue})) );
        assertEquals(
                optionalNull,
                AnswerHelper.categoryOrOther(new AnswerRequest(null, new String[]{null})) );
        assertEquals(
                optionalNull,
                AnswerHelper.categoryOrOther(new AnswerRequest(null, new String[]{})) );
        assertEquals(
                Optional.ofNullable(AnswerValuesOrTextEnum.TEXT),
                AnswerHelper.categoryOrOther(new AnswerRequest("testText", new String[]{})) );
        assertEquals(
                Optional.ofNullable(AnswerValuesOrTextEnum.VALUES),
                AnswerHelper.categoryOrOther(new AnswerRequest("", new String[]{testValue})) );
        assertEquals(
                optionalNull,
                AnswerHelper.categoryOrOther(new AnswerRequest(testText, new String[]{testValue})) );
        assertThrows(
                IllegalArgumentException.class,
                ()->{
                    optionalNull.orElseThrow(() -> new IllegalArgumentException()); } );
    }

}
