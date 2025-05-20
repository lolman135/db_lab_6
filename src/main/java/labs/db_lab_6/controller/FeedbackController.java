package labs.db_lab_6.controller;

import labs.db_lab_6.dto.FeedbackDto;
import labs.db_lab_6.entity.Feedback;
import labs.db_lab_6.service.feedback.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> findAll(){
        List<Feedback> feedbacks = feedbackService.findAll();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> findById(@PathVariable("id") Long id){
        Feedback feedback = feedbackService.findById(id);
        return ResponseEntity.ok(feedback);
    }

    @PostMapping("/feedbacks")
    public ResponseEntity<Feedback> save(@RequestBody FeedbackDto dto){
        Feedback feedback = feedbackService.save(dto);
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> updateById(@PathVariable("id") Long id, @RequestBody FeedbackDto dto){
        Feedback feedback = feedbackService.updateById(dto, id);
        return ResponseEntity.ok(feedback);
    }

    @DeleteMapping("/feedbacks/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(feedbackService.deleteById(id));
    }
}
