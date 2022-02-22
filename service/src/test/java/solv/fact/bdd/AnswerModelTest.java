package solv.fact.bdd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnswerModelTest {

    private final String requestTemplate = "{\"text\":\"test\",\"values\":[\"test0\",\"test1\"]}";

    @Test
    void test0() {
        ObjectMapper mapper = new ObjectMapper();
        TestObject testObject = null;
        try {
            testObject = mapper.readValue(requestTemplate, TestObject.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assertNotNull(testObject);
    }

    @Test
    void test1() {
        ObjectMapper mapper = new ObjectMapper();
        Object testObject = null;
        try {
            testObject = mapper.readValue(requestTemplate, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assertNotNull(testObject);
    }

}

class TestObject {
    private String text;
    private String[] values;

    public void setText(String text) {
        this.text = text;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}

