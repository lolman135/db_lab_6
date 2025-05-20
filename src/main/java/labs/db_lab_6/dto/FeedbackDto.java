package labs.db_lab_6.dto;

public record FeedbackDto(
        Long id,
        Long responseId,
        Long userId,
        String title,
        String comment
) {}
