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

import fev.management.biz.impl.EventBizImpl;
import fev.management.dto.EventCast;
import fev.management.dto.MemberCast;
import fev.management.entity.FevAccountRole;
import fev.management.entity.FevEvent;
import fev.management.model.AccountRoleModel;
import fev.management.model.EventModel;
import fev.management.repository.EventRepository;
import fev.management.repository.MemberRepository;

@Controller
public class EventController {
    
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventRepository eventRepo;

    @Autowired
    EventBizImpl eventBizImpl;
    
    @GetMapping("/management/event")
    public String member() {
        return "management/event";
    }
    
    @GetMapping("/management/event/loadHand")
    @ResponseBody
    public List<EventCast> loadData() {
        LOG.info("Data: ");
        List<Object[]> list = eventRepo.getAll();
        List<EventCast> listEvent = new ArrayList<>();
        for (Object[] objects : list) {
            int id = (int) objects[0];
            String name = (String) objects[1];
            Date start = (Date) objects[2];
            Date end = (Date) objects[3];
            Date time = (Date) objects[4];
            String place = (String) objects[5];
            String leader = (String) objects[6];
            String note = (String) objects[7];
            listEvent.add(new EventCast(id, name, start, end, time, place, leader, note));
        }

        return (List<EventCast>) listEvent;
    }
    
    @PostMapping("/management/event/saveEvent")
    @ResponseBody
    public List<FevEvent> saveTeam(@Valid @RequestBody EventModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevEvent> entities = fev.management.util.AppUtil.parseEvent(data);

            eventBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevEvent> account = (List<FevEvent>) eventRepo.findAll();

        return account;

    }
}
