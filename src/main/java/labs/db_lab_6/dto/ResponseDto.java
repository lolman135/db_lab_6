package labs.db_lab_6.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseDto(
        String description,
        String graphic,
        Long userId,
        List<Long> datasetIds,
        List<Long> feedbackIds
) {}
