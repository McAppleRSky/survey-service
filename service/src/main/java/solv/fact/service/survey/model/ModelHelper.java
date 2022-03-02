package solv.fact.service.survey.model;

import solv.fact.repository.entity.Question;
import solv.fact.repository.entity.QuestionVariant;
import solv.fact.repository.entity.Survey;
import solv.fact.service.question.model.QuestionFullResponse;
import solv.fact.service.question.model.QuestionRequest;
import solv.fact.service.question.model.QuestionTypeEnum;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ModelHelper {
    public static SurveyFullResponse createSurveyResponse(Survey entity) {
        return new SurveyFullResponse(
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

    public static Question updateQuestionEntityOrCreateIfNull(Question questionEntity, QuestionRequest requestedModel) {
        List<QuestionVariant> questionEntityVariants;
        if (questionEntity == null) {
            questionEntity = new Question();
        }
        questionEntity.setTitle(requestedModel.getTitle());
        QuestionTypeEnum type = requestedModel.getType();
        questionEntity.setQuestionType(type.getText());
        if (type != QuestionTypeEnum.TEXT) {
            List<String[]> requestQuestionVariants = requestedModel.getQuestionVariants();
            if (requestQuestionVariants != null) {
                if (!requestQuestionVariants.isEmpty()) {
                    List<QuestionVariant> entityQuestionVariants = new ArrayList<>();
                    for (String[] requestQuestionVariant : requestedModel.getQuestionVariants()) {
                        QuestionVariant entityQuestionVariant = new QuestionVariant();
                        entityQuestionVariant.setTitle(requestQuestionVariant[0]);
                        entityQuestionVariant.setValue(requestQuestionVariant[1]);
                        entityQuestionVariants.add(entityQuestionVariant);
                    }
                }
            }
        }
        return questionEntity;
    }

    public static QuestionFullResponse questionResponse(Question questionEntity) {
        List<String[]> questionVariantsForResponse = new ArrayList<>();
        for (QuestionVariant questionVariantEntity : questionEntity.getQuestionVariants()) {
            questionVariantsForResponse.add(new String[]{
                    questionVariantEntity.getTitle(),
                    questionVariantEntity.getValue()
            });
        }
        QuestionFullResponse resultQuestionResponse = new QuestionFullResponse(
                questionEntity.getTitle(),
                QuestionTypeEnum.valueOf(
                        questionEntity.getQuestionType() ),
                questionVariantsForResponse
        );
        return resultQuestionResponse;
    }

}
