package solv.fact.service.answer.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnswerRequestTest {

    private final String requestString = "{\"text\":\"test\",\"values\":[\"test0\",\"test1\"]}";
    private final String requestTextTemplate = "{\"text\":\"%s\",\"values\":[]}";
    private final String requestValue = "{\"text\":null,\"values\":[\"%s\"]}";

    @Test
    void testReadRequest() {
        ObjectMapper mapper = new ObjectMapper();
        AnswerRequest testObject = null;
        try {
            testObject = mapper.readValue(requestString, AnswerRequest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assertNotNull(testObject);
    }

    @Test
    void testReadText() {
        ObjectMapper mapper = new ObjectMapper();
        AnswerRequest testObject = null;
        String testText = randomAlphabetic(3);
        String requestString = String.format(requestTextTemplate, testText);
        try {
            testObject = mapper.readValue(requestString, AnswerRequest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assertNotNull(testObject);
        assertEquals(testText, testObject.getText());
        assertEquals(0, testObject.getValues().length);
    }

    @Test
    void testReadValue() {
        ObjectMapper mapper = new ObjectMapper();
        AnswerRequest testObject = null;
        String testText = randomAlphabetic(3);
        String requestString = String.format(requestValue, testText);
        try {
            testObject = mapper.readValue(requestString, AnswerRequest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assertNotNull(testObject);
        assertEquals(testText, testObject.getText());
        assertEquals(1, testObject.getValues().length);
    }

    //    @Test
    void testNotApplicable() {
        ObjectMapper mapper = new ObjectMapper();
        Object testObject = null;
        try {
            testObject = mapper.readValue(requestTextTemplate, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assertNotNull(testObject);
    }

}

