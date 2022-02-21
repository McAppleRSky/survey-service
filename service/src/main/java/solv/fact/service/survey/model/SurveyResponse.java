package solv.fact.service.survey.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class SurveyResponse {
    private final Integer id;
    private final String title;
    private final LocalDateTime start;
    private final LocalDateTime finish;
    private final String description;

}
