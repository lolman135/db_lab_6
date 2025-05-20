package labs.db_lab_6.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeedbackDto(
        Long responseId,
        Long userId,
        String title,
        String comment
) {}
