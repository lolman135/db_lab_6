package labs.db_lab_6.mapper;

import labs.db_lab_6.dto.ResponseDto;
import labs.db_lab_6.entity.Response;
import labs.db_lab_6.repository.DatasetRepository;
import labs.db_lab_6.repository.FeedbackRepository;

import java.util.stream.Collectors;

public class ResponseMapper {

    public static Response toEntity(
            ResponseDto dto,
            DatasetRepository datasetRepository,
            FeedbackRepository feedbackRepository)
    {
        Response response = new Response();

        response.setId(dto.id());
        response.setUserId(dto.userId());
        response.setGraphic(dto.graphic());
        response.setDescription(dto.description());

        response.setDatasets(
                dto.datasetIds().stream()
                        .map(datasetId -> datasetRepository.findById(datasetId).orElse(null))
                        .toList()
        );

        response.setFeedbacks(
                dto.feedbackIds().stream()
                        .map(feedbackId -> feedbackRepository.findById(feedbackId).orElse(null))
                        .toList()
        );

        return response;
    }
}
