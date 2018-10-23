package fev.management.api;

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
import fev.management.repository.EventRepository;

@Controller
public class EventController implements BaseController<FevEvent> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    private final String path = "/events";
    
    @Autowired
    EventRepository eventRepository;

    // GET
    // Display all event
    @GetMapping("/events")
    @ResponseBody
    public List<FevEvent> getAll() {

        return (List<FevEvent>) eventRepository.findAll();
        // return "Get All Event";
    }

    // Get Event By ID
    @GetMapping("/events/{id}")
    @ResponseBody
    public Optional<FevEvent> getByID(@PathVariable("id") int id) {

        return eventRepository.findById(id);
    }

    // Return total of event
    @GetMapping("/events/count")
    @ResponseBody
    @Override
    public long getCount() {

        return eventRepository.count();
    }

    // DELETE
    // Get Event By ID
    @DeleteMapping("/events/{id}")
    @ResponseBody
    public void deleteByID(@PathVariable("id") int id) {

        eventRepository.deleteById(id);

    }

    // CREATE
    // Create new Event
    @PostMapping("/events/{event}")
    @ResponseBody
    public void create(@PathVariable("event") FevEvent event) {

        eventRepository.save(event);
    }

    // UPDATE
    // Create new Event
    @PutMapping("/events/{event}")
    @ResponseBody
    public void update(@PathVariable("event") FevEvent event) {

        eventRepository.save(event);
    }

}
