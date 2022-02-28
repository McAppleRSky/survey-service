package solv.fact.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import solv.fact.repository.entity.Answer;
import solv.fact.repository.entity.Participation;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan(basePackages = "solv.fact")
class AnswerRepositoryValuesTest {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerRepositoryQuery answerRepositoryQuery;

    @Autowired
    private ParticipationRepository participationRepository;

    @Test
    void createAnswerValuesTest() {
        int personIdTest = nextInt(),
                questionIdTest = nextInt(),
                surveyIdTest = nextInt();
        String value0 = randomAlphabetic(3),
                value1 = randomAlphabetic(3);
        String[] valuesTest = new String[]{value0, value1};
//        LOGGER.info("create participation");
        int participationCreatedId = answerRepository.createAnswerParticipationReturnId(
                surveyIdTest,
                questionIdTest,
                personIdTest );
//        LOGGER.info("create answer(s)");
        answerRepository.createAnswerValues(valuesTest, participationCreatedId);
//        LOGGER.info("find answer(s)");
        List<Answer> actualAnswerList = answerRepositoryQuery.findAnswerById(participationCreatedId);
//        LOGGER.info("assert begin");
        assertFalse(actualAnswerList.isEmpty());
        assertEquals(2, actualAnswerList.size());
        assertNull(actualAnswerList.get(0).getText());
        assertTrue(actualAnswerList.get(0).getId() >= 0);
        assertEquals(participationCreatedId, actualAnswerList.get(0).getParticipationId());
        assertEquals(value0, actualAnswerList.get(0).getValue());
        assertEquals(value1, actualAnswerList.get(1).getValue());
        Participation participation = participationRepository.findById(actualAnswerList.get(0).getParticipationId());
        assertEquals(personIdTest, participation.getPersonId());
        assertEquals(questionIdTest, participation.getQuestionId());
        assertEquals(surveyIdTest, participation.getSurveyId());
//        LOGGER.info("assert end");
    }

}
