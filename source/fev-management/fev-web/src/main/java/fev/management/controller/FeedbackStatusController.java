package fev.management.controller;

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

import fev.management.biz.impl.FeedbackStatusBizImpl;
import fev.management.entity.FevFeedbackStatus;
import fev.management.entity.FevInventoryStatus;
import fev.management.model.FeedbackStatusModel;
import fev.management.model.InventoryStatusModel;
import fev.management.repository.FeedbackStatusRepository;
import fev.management.repository.InventoryStatusRepository;
import fev.management.util.AppUtil;

@Controller
public class FeedbackStatusController {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(FeedbackStatusController.class);

    @Autowired
    FeedbackStatusRepository fbStatusRepo;
    
    @Autowired
    FeedbackStatusBizImpl fbStatusBizImpl;
    
    @GetMapping("/management/feedback/status")
    public String feedbackStatus() {
        return "management/feedback_status";
    }

    @GetMapping("/management/feedback/status/loadHand")
    @ResponseBody
    public List<FevFeedbackStatus> loadData() {
        return (List<FevFeedbackStatus>) fbStatusRepo.findAll();
    }

    @PostMapping("/management/feedback/status/save")
    @ResponseBody
    public List<FevFeedbackStatus> saveInventoryStatus(@Valid @RequestBody FeedbackStatusModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save feedback status...");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevFeedbackStatus> entities = AppUtil.parseFeedbackStatus(data);

            fbStatusBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevFeedbackStatus> fbStatus = (List<FevFeedbackStatus>) fbStatusRepo.findAll();

        return fbStatus;

    }
}
