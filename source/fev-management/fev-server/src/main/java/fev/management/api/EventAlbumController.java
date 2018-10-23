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

import fev.management.entity.FevEventAlbum;
import fev.management.repository.EventAlbumRepository;
import fev.management.repository.EventRepository;

@Controller
public class EventAlbumController implements BaseController<FevEventAlbum> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    private final String path = "/events/albums";

    @Autowired
    EventAlbumRepository eventAlbumRepository;

    // GET
    // Display all album
    @GetMapping(path)
    @ResponseBody
    @Override
    public List<FevEventAlbum> getAll() {
        // TODO Auto-generated method stub
        return (List<FevEventAlbum>) eventAlbumRepository.findAll();
    }

    // Get Album By ID
    @GetMapping(path + "/{id}")
    @ResponseBody
    @Override
    public Optional<FevEventAlbum> getByID(@PathVariable("id") int id) {
        // TODO Auto-generated method stub
        return eventAlbumRepository.findById(id);
    }

    @GetMapping(path + "/count")
    @ResponseBody
    @Override
    public long getCount() {
        // TODO Auto-generated method stub
        return eventAlbumRepository.count();
    }

    // Get Event By ID
    @DeleteMapping(path + "/{id}")
    @ResponseBody
    @Override
    public void deleteByID(@PathVariable("id") int id) {
        eventAlbumRepository.deleteById(id);

    }

    @PostMapping(path + "/{album}")
    @ResponseBody
    @Override
    public void create(@PathVariable("album") FevEventAlbum object) {
        // TODO Auto-generated method stub
        eventAlbumRepository.save(object);
    }

    // Create new Event
    @PutMapping(path + "/{album}")
    @ResponseBody
    @Override
    public void update(@PathVariable("album") FevEventAlbum object) {
        // TODO Auto-generated method stub
        eventAlbumRepository.save(object);
    }

}
