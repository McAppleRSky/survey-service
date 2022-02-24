package solv.fact.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import solv.fact.service.answer.model.AnswerRequest;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ComponentScan(basePackages = "solv.fact")
class AnswerRepositoryTest {

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void createAnswerText() {
        int surveyIdTest = nextInt(),
            questionIdTest = nextInt(),
            personIdTest = nextInt();
        String textTest = randomAlphabetic(3);
        AnswerRequest textRequestTest = new AnswerRequest(
                textTest, new String[]{} );
        int actualResult = answerRepository.createAnswerText(surveyIdTest, questionIdTest, personIdTest, textRequestTest);
        assertEquals(0, actualResult);
        System.out.println();
    }

    void createAnswerValues() {
    }

}
