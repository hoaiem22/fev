package fev.management.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fev.management.biz.impl.FeedbackBizImpl;
import fev.management.dto.EventCast;
import fev.management.dto.FeedbackCast;
import fev.management.entity.FevEvent;
import fev.management.entity.FevFeedback;
import fev.management.model.EventModel;
import fev.management.model.FeedbackModel;
import fev.management.repository.FeedbackRepository;
import fev.management.util.AppUtil;

@Controller
public class FeedbackController {
    
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(FeedbackController.class);
    
    @Autowired
    FeedbackRepository feedbackRepo;
    
    @Autowired
    FeedbackBizImpl feedbackBizImpl;
    
    @GetMapping("/management/feedback")
    public String feedback() {
        return "management/feedback";
    }
    
    @GetMapping("/management/feedback/loadHand")
    @ResponseBody
    public List<FeedbackCast> loadData() {
        List<Object[]> list = feedbackRepo.getAll();
        List<FeedbackCast> listFeedback = new ArrayList<>();
        for (Object[] objects : list) {
            int id = (int) objects[0];
            String sender = (String) objects[1];
            String content = (String) objects[2];
            String status = (String) objects[3];
            String note = (String) objects[4];
            listFeedback.add(new FeedbackCast(id, sender, content, status, note));
        }

        return (List<FeedbackCast>) listFeedback;
    }
    
    @PostMapping("/management/feedback/save")
    @ResponseBody
    public List<FevFeedback> saveFeedback(@Valid @RequestBody FeedbackModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevFeedback> entities = AppUtil.parseFeedback(data);

            feedbackBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevFeedback> feedbacks = (List<FevFeedback>) feedbackRepo.findAll();

        return feedbacks;

    }
}
