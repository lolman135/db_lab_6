package labs.db_lab_6.dto;

import java.util.List;

public record ResponseDto(
        Long id,
        String description,
        String graphic,
        Long userId,
        List<Long> datasetIds,
        List<Long> feedbackIds
) {}
