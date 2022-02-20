package solv.fact.service.question;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import solv.fact.repository.QuestionRepository;
import solv.fact.service.question.model.QuestionRequest;
import solv.fact.service.question.model.QuestionResponse;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public int createQuestion(Integer surveyId, QuestionRequest requested) {
        throw new NotImplementedException("Question service method not implemented");
    }

    @Override
    public QuestionResponse updateQuestion(Integer surveyId, Integer questionId, QuestionRequest requested) {
        throw new NotImplementedException("Question service method not implemented");
    }

    @Override
    public void deleteQuestion(Integer surveyId, Integer questionId) {
        throw new NotImplementedException("Question service method not implemented");
    }

}
