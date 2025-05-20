package labs.db_lab_6.service.feedback;

import labs.db_lab_6.dto.DatasetDto;
import labs.db_lab_6.dto.FeedbackDto;
import labs.db_lab_6.entity.Dataset;
import labs.db_lab_6.entity.Feedback;
import labs.db_lab_6.exception.ResourceNotFoundException;
import labs.db_lab_6.mapper.DatasetMapper;
import labs.db_lab_6.mapper.FeedbackMapper;
import labs.db_lab_6.repository.FeedbackRepository;
import labs.db_lab_6.repository.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final ResponseRepository responseRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, ResponseRepository responseRepository) {
        this.feedbackRepository = feedbackRepository;
        this.responseRepository = responseRepository;
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback findById(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Wrong id provided");
        }
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with id:" + id));
    }

    @Override
    public Feedback save(FeedbackDto dto) {
        if (dto == null){
            throw new IllegalArgumentException("Wrong data provided");
        }
        Feedback feedback = FeedbackMapper.toEntity(dto, responseRepository);
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback updateById(FeedbackDto dto, Long id) {
        if (id == null || dto == null){
            throw new IllegalArgumentException("Wrong data provided");
        }

        if (feedbackRepository.existsById(id)){
            Feedback feedback = FeedbackMapper.toEntity(dto, responseRepository);
            feedback.setId(id);
            return feedbackRepository.save(feedback);
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (feedbackRepository.existsById (id)){
            feedbackRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
