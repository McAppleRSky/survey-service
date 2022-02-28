package solv.fact.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import solv.fact.repository.entity.*;
import solv.fact.service.survey.model.QuestionTypeEnum;

import java.sql.Timestamp;
import java.util.ArrayList;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan(basePackages = "solv.fact")
class PersonAnswerTest {

    private static Logger LOGGER = LoggerFactory.getLogger(AnswerRepositoryTextTest.class);

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AnswerRepositoryQuery answerRepositoryQuery;

    @Test
    void findAllByPersonTest() {
        final String name = randomAlphabetic(3) + " "  + randomAlphabetic(3);
        final String login = randomAlphabetic(3);
        final String password = randomAlphabetic(8);
        final String email = randomAlphabetic(3)
                + "@"  + randomAlphabetic(3)
                + "." +  randomAlphabetic(2);

        LOGGER.info("assert begin");
        assertNotNull( personRepository.save(new Person(null, name, login, password, email, null)) );
        assertEquals(2, personRepository.findAll().size());

        final String titleSurvey = randomAlphabetic(3);
        final Timestamp start = Timestamp.valueOf(now());
        final Timestamp finish = Timestamp.valueOf(now());
        final String description = randomAlphabetic(3);
        Survey surveySaved = surveyRepository
                .save(
                        new Survey(
                                null,
                                titleSurvey,
                                start,
                                finish,
                                description,
                                new ArrayList<>()));

        final String titleQuestion = randomAlphabetic(3);

        Question question = new Question(
                null,
                titleQuestion,
                surveySaved,
                QuestionTypeEnum.RADIO.getText(),
                new ArrayList<>());
        Question questionSaved = questionRepository.save(question);
        surveySaved.getQuestions().add(questionSaved);



        Survey saved2 = surveyRepository.save(surveySaved);

        Integer surveyId = surveySaved.getId();
        Integer questionId = surveySaved.getQuestions().get(0).getId();
        Integer personId = 1;
        Participation participationSaved = participationRepository
                .save(
                        new Participation(
                                null,
                                surveyId,
                                questionId,
                                personId));
        assertEquals(2, personRepository.findAll().size());

        final String value = randomAlphabetic(3);
        Answer answer = new Answer(null, value, null, participationSaved.getId());
        answerRepository.save(answer)
        LOGGER.info("assert end");
    }

}