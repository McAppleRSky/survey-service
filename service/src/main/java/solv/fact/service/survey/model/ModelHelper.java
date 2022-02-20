package solv.fact.service.survey.model;

import solv.fact.repository.entity.Question;
import solv.fact.repository.entity.QuestionVariant;
import solv.fact.repository.entity.Survey;
import solv.fact.service.question.model.QuestionRequest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ModelHelper {
    public static SurveyResponse createSurveyResponse(Survey entity) {
        return new SurveyResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getStart().toLocalDateTime(),
                entity.getFinish().toLocalDateTime(),
                entity.getDescription()
        );
    }

    public static Survey createSurveyPullEntity(SurveyRequest requested) {
        return new Survey(
                null,
                requested.getTitle(),
                Timestamp.valueOf(
                        requested.getStart() ),
                Timestamp.valueOf(
                        requested.getFinish() ),
                requested.getDescription()
                ,null );
    }

    public static Survey updateSurveyPullEntity(Survey updating, SurveyRequestPull requested) {
        updating.setTitle(requested.getTitle());
        updating.setFinish(
                Timestamp.valueOf(
                        requested.getFinish() ) );
        updating.setDescription(requested.getDescription());
        return updating;
    }

    public static Question createQuestionEntity(QuestionRequest requested) {
        Question resultQuestion = new Question();
        resultQuestion.setTitle(requested.getTitle());
        QuestionTypeModel type = requested.getType();
        resultQuestion.setQuestionType(type.getText());
        if (type != QuestionTypeModel.TEXT) {
            List<String[]> requestQuestionVariants = requested.getQuestionVariants();
            if (requestQuestionVariants != null) {
                if (!requestQuestionVariants.isEmpty()) {
                    List<QuestionVariant> entityQuestionVariants = new ArrayList<>();
                    for (String[] requestQuestionVariant : requested.getQuestionVariants()) {
                        QuestionVariant entityQuestionVariant = new QuestionVariant();
                        entityQuestionVariant.setTitle(requestQuestionVariant[0]);
                        entityQuestionVariant.setValue(requestQuestionVariant[1]);
                        entityQuestionVariants.add(entityQuestionVariant);
                    }
                }
            }
        }
        return resultQuestion;
    }
}
