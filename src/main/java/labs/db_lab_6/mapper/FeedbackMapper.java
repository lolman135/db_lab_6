package labs.db_lab_6.mapper;

import labs.db_lab_6.dto.FeedbackDto;
import labs.db_lab_6.entity.Feedback;
import labs.db_lab_6.repository.ResponseRepository;

public class FeedbackMapper {

    public static Feedback toEntity(FeedbackDto dto, ResponseRepository repository){
        Feedback feedback = new Feedback();
        if (dto.responseId() != null) {
            feedback.setResponse(repository.findById(dto.responseId()).orElse(null));
        }

        feedback.setUserId(dto.userId());
        feedback.setTitle(dto.title());
        feedback.setComment(dto.comment());

        return feedback;
    }
}
