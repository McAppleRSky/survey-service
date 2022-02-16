package solv.fact.service.survey;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import solv.fact.repository.SurveyRepository;
import solv.fact.service.survey.model.SurveyRequestPull;
import solv.fact.service.survey.model.SurveyRequest;
import solv.fact.service.survey.model.SurveyResponse;
import solv.fact.service.survey.model.SurveysFullResponse;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    @Override
    public SurveyResponse update(Integer id, SurveyRequestPull requested) {
        throw new NotImplementedException("Survey service method not implemented");
    }

    @Override
    public int create(SurveyRequest requested) {
        throw new NotImplementedException("Survey service method not implemented");
    }

    @Override
    public void delete(Integer id) {
        throw new NotImplementedException("Survey service method not implemented");
    }

    @Override
    public SurveysFullResponse findAllActive() {
        throw new NotImplementedException("Survey service method not implemented");
    }

}
