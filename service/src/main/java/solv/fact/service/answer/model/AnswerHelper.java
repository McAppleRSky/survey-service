package solv.fact.service.answer.model;

import solv.fact.service.question.model.QuestionResponse;
import solv.fact.service.survey.model.SurveyResponse;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.ObjectUtils.isEmpty;

public class AnswerHelper {

    @Nonnull
    public static Optional<AnswerValuesOrTextEnum> categoryOrOther(@Nonnull AnswerRequest requested) {
        boolean notText = isEmpty(requested.getText());
        boolean notValue = requested.getValues().length == 0;
        return Optional.ofNullable(
                !(notText ^ notValue) ? null :
                        notValue ? AnswerValuesOrTextEnum.TEXT :
                                isEmpty(requested.getValues()[0]) ? null : AnswerValuesOrTextEnum.VALUES );
    }

    @Nonnull
    public static List<AnswerTuple> createAnswerTuples(@Nonnull List<Object[]> tuples) {
        final int
                _0_SURVEY_ID        = 0,
                _1_SURVEY_TITLE     = 1,
                _2_QUESTION_ID      = 2,
                _3_QUESTION_TITLE   = 3,
                _4_QUESTION_TYPE    = 4,
                _5_ANSWER_TEXT      = 5,
                _6_ANSWER_VALUE     = 6;
        List<AnswerTuple> result = new ArrayList<>();
        for (Object[] tuple : tuples) {
            result.add(
                    new AnswerTuple(
                            (Integer)tuple[_0_SURVEY_ID],
                            (String )tuple[_1_SURVEY_TITLE],
                            (Integer)tuple[_2_QUESTION_ID],
                            (String )tuple[_3_QUESTION_TITLE],
                            (String )tuple[_4_QUESTION_TYPE],
                            tuple[_5_ANSWER_TEXT] == null ?
                                    null : (String)tuple[_5_ANSWER_TEXT],
                            tuple[_6_ANSWER_VALUE  ] == null ?
                                    null : (String)tuple[_6_ANSWER_VALUE]) );
        }
        return result;
    }

    public static List<SurveyResponse> createSurveyQuestionAnswersResponse(List<AnswerTuple> answerTuples) {
        List<SurveyResponse> surveysResponseResult = null;
        Integer currentSurveyId = null, currentSurveyI = null,
                currentQuestionId = null, currentQuestionI = null,
                currentAnswerI = null;
        for (AnswerTuple answerTuple : answerTuples) {
            if (answerTuple.getSurveyId() != currentSurveyId) {
                if (surveysResponseResult == null) {
                    surveysResponseResult = new ArrayList<>();
                    currentSurveyI = -1;
                }
                surveysResponseResult
                        .add(
                                new SurveyResponse(
                                        answerTuple.getSurveyTitle(),
                                        new ArrayList<>()));
                currentQuestionI = -1;
                currentSurveyI += 1;
                currentSurveyId = answerTuple.getSurveyId();
            }

            if (answerTuple.getQuestionId() != currentQuestionId) {
                surveysResponseResult
                        .get(currentSurveyI)
                        .getQuestionsResponse()
                        .add(
                                new QuestionResponse(
                                        answerTuple.getQuestionTitle(),
                                        answerTuple.getQuestionType(),
                                        new AnswerResponse(
                                                null,
                                                new ArrayList<>() ) ) );
                currentQuestionI += 1;
                currentQuestionId = answerTuple.getQuestionId();
            }
            if (answerTuple.getAnswerText() == null ^ answerTuple.getAnswerValue() == null) {
                if (answerTuple.getAnswerText() != null) {
                    surveysResponseResult
                            .get(currentSurveyI)
                            .getQuestionsResponse()
                            .get(currentQuestionI)
                            .getAnswerResponse()
                            .setText(
                                    answerTuple
                                            .getAnswerText() );
                } else {
                    surveysResponseResult
                            .get(currentSurveyI)
                            .getQuestionsResponse()
                            .get(currentQuestionI)
                            .getAnswerResponse()
                            .getValues()
                            .add(
                                    answerTuple
                                            .getAnswerValue() );
                }
            }
        }
        return surveysResponseResult;
    }

}
