package fev.management.api;

import java.lang.annotation.Inherited;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fev.management.entity.FevEvent;
import fev.management.entity.FevFeedback;
import fev.management.repository.FeedbackRepository;

@Controller
public class FeedbackController implements BaseController<FevFeedback> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(FeedbackRepository.class);     
    
    @Autowired
    FeedbackRepository feedbackRepository;

    @GetMapping("/feedbacks")
    @ResponseBody
    @Override
    public List<FevFeedback> getAll() {
        return (List<FevFeedback>) feedbackRepository.findAll();
    }

    @GetMapping("/feedbacks/{id}")
    @ResponseBody
    @Override
    public Optional<FevFeedback> getByID(@PathVariable("id") int id) {
        // TODO Auto-generated method stub
        return feedbackRepository.findById(id);
    }

    // Return total of event
    @GetMapping("/feedbacks/count")
    @ResponseBody
    @Override
    public long getCount() {

        return feedbackRepository.count();
    }

    @DeleteMapping("/feedbacks/{id}")
    @ResponseBody
    @Override
    public void deleteByID(@PathVariable("id") int id) {

        feedbackRepository.deleteById(id);
    }

    // CREATE
    // Create new Event
    @PostMapping("/events/{feedback}")
    @ResponseBody
    @Override
    public void create(@PathVariable("feedback") FevFeedback feedback) {

        feedbackRepository.save(feedback);
    }

    // UPDATE
    // Create new Event
    @PutMapping("/events/{feedback}")
    @ResponseBody
    @Override
    public void update(@PathVariable("feedback") FevFeedback feedback) {

        feedbackRepository.save(feedback);
    }

}
