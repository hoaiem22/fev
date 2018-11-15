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

import fev.management.biz.impl.EventAlbumBizImpl;
import fev.management.dto.EventAlbumCast;
import fev.management.dto.EventCast;
import fev.management.entity.FevEvent;
import fev.management.entity.FevEventAlbum;
import fev.management.model.EventAlbumModel;
import fev.management.model.EventModel;
import fev.management.repository.EventAlbumRepository;
import fev.management.util.AppUtil;

@Controller
public class EventAlbumController {
    
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(AccountRoleController.class);
    
    @Autowired
    EventAlbumRepository eventAlbumRepo;
    
    @Autowired
    EventAlbumBizImpl eventAlbumBizImpl;
    
    @GetMapping("/management/event/album")
    public String event_album() {
        return "management/event_album";
    }
    
    @GetMapping("/management/event/album/loadHand")
    @ResponseBody
    public List<EventAlbumCast> loadData() {
        LOG.info("Data: ");
        List<Object[]> list = eventAlbumRepo.getAll();
        List<EventAlbumCast> listEvent = new ArrayList<>();
        for (Object[] objects : list) {
            int id = (int) objects[0];
            String event = (String) objects[1];         
            String img = (String) objects[2];     
            listEvent.add(new EventAlbumCast(id, event, img));
        }

        return (List<EventAlbumCast>) listEvent;
    }
    
    @PostMapping("/management/event/album/saveEventAlbum")
    @ResponseBody
    public List<FevEventAlbum> saveTeam(@Valid @RequestBody EventAlbumModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevEventAlbum> entities = AppUtil.parseEventAlbum(data);

            eventAlbumBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevEventAlbum> account = (List<FevEventAlbum>) eventAlbumRepo.findAll();

        return account;

    }
    
}
