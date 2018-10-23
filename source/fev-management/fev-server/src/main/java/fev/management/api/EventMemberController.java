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
import org.springframework.web.bind.annotation.ResponseBody;

import fev.management.entity.FevEventMember;
import fev.management.repository.EventMemberRepository;

@Controller
public class EventMemberController implements BaseController<FevEventMember> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    private final String path = "/events/members";

    @Autowired
    EventMemberRepository eventMemberRepository;

    // GET
    // Display all album
    @GetMapping(path)
    @ResponseBody
    @Override
    public List<FevEventMember> getAll() {
        // TODO Auto-generated method stub
        return (List<FevEventMember>) eventMemberRepository.findAll();
    }

    // Get Album By ID
    @GetMapping(path + "/{id}")
    @ResponseBody
    @Override
    public Optional<FevEventMember> getByID(@PathVariable("id") int id) {
        // TODO Auto-generated method stub
        return eventMemberRepository.findById(id);
    }

    @GetMapping(path + "/count")
    @ResponseBody
    @Override
    public long getCount() {
        // TODO Auto-generated method stub
        return eventMemberRepository.count();
    }

    // Get Event By ID
    @DeleteMapping(path + "/{id}")
    @ResponseBody
    @Override
    public void deleteByID(@PathVariable("id") int id) {
        // TODO Auto-generated method stub
        eventMemberRepository.deleteById(id);
    }

    @PostMapping(path + "/{em}")
    @ResponseBody
    @Override
    public void create(@PathVariable("em") FevEventMember object) {
        // TODO Auto-generated method stub
        eventMemberRepository.save(object);
    }

    // Create new Event
    @PutMapping(path + "/{em}")
    @ResponseBody
    @Override
    public void update(@PathVariable("em") FevEventMember object) {
        // TODO Auto-generated method stub
        eventMemberRepository.save(object);
    }

}
