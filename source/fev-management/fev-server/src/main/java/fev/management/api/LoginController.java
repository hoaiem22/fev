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

import fev.management.entity.FevInventoryStatus;
import fev.management.entity.FevLogin;
import fev.management.repository.InventoryStatusRepository;
import fev.management.repository.LoginRepository;

@Controller
public class LoginController implements BaseController<FevLogin> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    private final String path = "/logins";

    @Autowired
    LoginRepository loginRepository;

    // GET
    // Display all album
    @GetMapping(path)
    @ResponseBody
    @Override
    public List<FevLogin> getAll() {
        // TODO Auto-generated method stub
        return (List<FevLogin>) loginRepository.findAll();
    }

    // Get Album By ID
    @GetMapping(path + "/{id}")
    @ResponseBody
    @Override
    public Optional<FevLogin> getByID(@PathVariable("id") int id) {
        // TODO Auto-generated method stub
        return loginRepository.findById(id);
    }

    @GetMapping(path + "/count")
    @ResponseBody
    @Override
    public long getCount() {
        // TODO Auto-generated method stub
        return loginRepository.count();
    }

    // Get Event By ID
    @DeleteMapping(path + "/{id}")
    @ResponseBody
    @Override
    public void deleteByID(@PathVariable("id") int id) {
        loginRepository.deleteById(id);

    }

    @PostMapping(path + "/{account}")
    @ResponseBody
    @Override
    public void create(@PathVariable("account") FevLogin object) {
        // TODO Auto-generated method stub
        loginRepository.save(object);
    }

    // Create new Event
    @PutMapping(path + "/{account}")
    @ResponseBody
    @Override
    public void update(@PathVariable("account") FevLogin object) {
        // TODO Auto-generated method stub
        loginRepository.save(object);
    }
}