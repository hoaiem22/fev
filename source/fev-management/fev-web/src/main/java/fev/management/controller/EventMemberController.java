package fev.management.controller;

import java.util.ArrayList;
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

import fev.management.biz.impl.EventMemberBizImpl;
import fev.management.dto.EventAlbumCast;
import fev.management.dto.EventMemberCast;
import fev.management.entity.FevEventAlbum;
import fev.management.entity.FevEventMember;
import fev.management.model.EventAlbumModel;
import fev.management.model.EventMemberModel;
import fev.management.repository.EventAlbumRepository;
import fev.management.repository.EventMemberRepository;
import fev.management.util.AppUtil;

@Controller
public class EventMemberController {
    
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventMemberController.class);
    
    @Autowired
    EventMemberRepository eventMemRepo;
    
    @Autowired
    EventMemberBizImpl eventMemBizImpl;
    
    @GetMapping("/management/event/member")
    public String event_member() {
        return "management/event_member";
    }
    
    @GetMapping("/management/event/member/loadHand")
    @ResponseBody
    public List<EventMemberCast> loadData() {
        LOG.info("Data: ");
        List<Object[]> list = eventMemRepo.getAll();
        List<EventMemberCast> listEventMember = new ArrayList<>();
        for (Object[] objects : list) {
            int id = (int) objects[0];
            String event = (String) objects[1];         
            String member1 = (String) objects[2];  
            String note = (String) objects[3];
            listEventMember.add(new EventMemberCast(id, event, member1, note));
        }

        return (List<EventMemberCast>) listEventMember;
    }
    
    @PostMapping("/management/event/member/saveEventMember")
    @ResponseBody
    public List<FevEventMember> saveEventMember(@Valid @RequestBody EventMemberModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save event member...");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevEventMember> entities = AppUtil.parseEventMember(data);

            eventMemBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevEventMember> eventMember = (List<FevEventMember>) eventMemRepo.findAll();

        return eventMember;

    }
}
