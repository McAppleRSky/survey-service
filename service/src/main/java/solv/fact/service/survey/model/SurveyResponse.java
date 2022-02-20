package solv.fact.service.survey.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
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
