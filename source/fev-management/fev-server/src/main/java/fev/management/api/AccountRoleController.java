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

import fev.management.entity.FevAccountRole;
import fev.management.repository.AccountRoleRepository;

@Controller
public class AccountRoleController implements BaseController<FevAccountRole> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    private final String path = "/logins/roles";

    @Autowired
    AccountRoleRepository loginRoleRepository;

    // GET
    // Display all album
    @GetMapping(path)
    @ResponseBody
    @Override
    public List<FevAccountRole> getAll() {
        // TODO Auto-generated method stub
        return (List<FevAccountRole>) loginRoleRepository.findAll();
    }

    // Get Album By ID
    @GetMapping(path + "/{id}")
    @ResponseBody
    @Override
    public Optional<FevAccountRole> getByID(@PathVariable("id") int id) {
        // TODO Auto-generated method stub
        return loginRoleRepository.findById(id);
    }

    @GetMapping(path + "/count")
    @ResponseBody
    @Override
    public long getCount() {
        // TODO Auto-generated method stub
        return loginRoleRepository.count();
    }

    // Get Event By ID
    @DeleteMapping(path + "/{id}")
    @ResponseBody
    @Override
    public void deleteByID(@PathVariable("id") int id) {
        loginRoleRepository.deleteById(id);

    }

    @PostMapping(path + "/{accRole}")
    @ResponseBody
    @Override
    public void create(@PathVariable("accRole") FevAccountRole object) {
        // TODO Auto-generated method stub
        loginRoleRepository.save(object);
    }

    // Create new Event
    @PutMapping(path + "/{accRole}")
    @ResponseBody
    @Override
    public void update(@PathVariable("accRole") FevAccountRole object) {
        // TODO Auto-generated method stub
        loginRoleRepository.save(object);
    }
}