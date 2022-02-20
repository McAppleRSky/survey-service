package solv.fact.service.survey.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class SurveyRequest {
    String title;
    LocalDateTime start;
    LocalDateTime finish;
    String description;
}
