package solv.fact.service.survey;

import solv.fact.service.survey.model.SurveyRequestPull;
import solv.fact.service.survey.model.SurveyRequest;
import solv.fact.service.survey.model.SurveyResponse;
import solv.fact.service.survey.model.SurveysFullResponse;

import java.util.Collection;

public interface SurveyService {
    SurveyResponse update(Integer id, SurveyRequestPull requested);
    int create(SurveyRequest requested);
    void delete(Integer id);
    SurveysFullResponse findAllActive();
}
