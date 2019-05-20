package fev.management.api;

import java.lang.reflect.Method;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fev.management.entity.FevAccount;
import fev.management.repository.AccountRepository;
import fev.management.service.UserService;

@Controller
public class AccountController implements BaseController<FevAccount> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    private final String path = "/logins";

    @Autowired
    AccountRepository loginRepository;

    @Autowired
    private UserService userService;
    
    // GET
    // Display all album
    @GetMapping(path)
    @ResponseBody
    @Override
    public List<FevAccount> getAll() {
        // TODO Auto-generated method stub
        return (List<FevAccount>) loginRepository.findAll();
    }

    // Get Album By ID
    @GetMapping(path + "/{id}")
    @ResponseBody
    @Override
    public Optional<FevAccount> getByID(@PathVariable("id") int id) {
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

    @PostMapping(path)
    @ResponseBody
    @Override
    public void create(@RequestBody FevAccount object) {
        // TODO Auto-generated method stub
        loginRepository.save(object);
    }

    // Create new Event
    @PutMapping(path + "/{account}")
    @ResponseBody
    @Override
    public void update(@PathVariable("account") FevAccount object) {
        // TODO Auto-generated method stub
        loginRepository.save(object);
    }
    
    @RequestMapping(value = path + "/checkLogin/username={username}&password={password}", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
        // TODO Auto-generated method stub
        
        
        return userService.checkLogin(username, password);
    }
    @RequestMapping(value = path + "/checkLogin/username={username}&password={password}", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkLogin2(@PathVariable("username") String username, @PathVariable("password") String password) {
        // TODO Auto-generated method stub
        
        
        return userService.checkLogin(username, password);
    }
    
}