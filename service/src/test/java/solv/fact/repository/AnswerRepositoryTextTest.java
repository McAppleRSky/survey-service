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
class AnswerRepositoryTextTest {

//    private static Logger LOGGER = LoggerFactory.getLogger(AnswerRepositoryTextTest.class);

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerRepositoryQuery answerRepositoryQuery;

    @Autowired
    private ParticipationRepository participationRepository;

    // https://habr.com/ru/post/435114/
    @Test
    void createAnswerTextTest() {
        int personIdTest = nextInt(),
            questionIdTest = nextInt(),
            surveyIdTest = nextInt();
        String textTest = randomAlphabetic(3);
        int participationCreatedId = answerRepository.createAnswerParticipationReturnId(
                surveyIdTest,
                questionIdTest,
                personIdTest );
        answerRepositoryQuery.createAnswerText(textTest, participationCreatedId);
        List<Answer> actualAnswerList = answerRepositoryQuery.findAnswerById(participationCreatedId);
//        LOGGER.info("assert begin");
        assertFalse(actualAnswerList.isEmpty());
        assertEquals(1, actualAnswerList.size());
        assertNull(actualAnswerList.get(0).getValue());
        assertTrue(actualAnswerList.get(0).getId() >= 0);
        assertEquals(textTest, actualAnswerList.get(0).getText());
        assertEquals(participationCreatedId, actualAnswerList.get(0).getParticipationId());
        Participation participation = participationRepository.findById(actualAnswerList.get(0).getParticipationId());
        assertEquals(personIdTest, participation.getPersonId());
        assertEquals(questionIdTest, participation.getQuestionId());
        assertEquals(surveyIdTest, participation.getSurveyId());
//        LOGGER.info("assert end");
    }

}
