package solv.fact.service.answer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerServiceIdEqualsTest {

    @Test
    void test1(){
        Integer nullableInteger = null, oneInteger = 1;
        assertTrue(nullableInteger != oneInteger);
    }

}