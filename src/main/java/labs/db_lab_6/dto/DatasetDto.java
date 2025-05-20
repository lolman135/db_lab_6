package labs.db_lab_6.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatasetDto(
        Long responseId,
        String text,
        String imageUrl,
        String diagram,
        String label,
        String source
) {}
