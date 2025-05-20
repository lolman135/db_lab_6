package labs.db_lab_6.dto;

public record DatasetDto(
        Long id,
        Long responseId,
        String text,
        String imageUrl,
        String diagram,
        String label,
        String source
) {}
