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
import fev.management.entity.FevLoginRole;
import fev.management.entity.FevMember;
import fev.management.entity.FevMemberPosition;
import fev.management.repository.InventoryStatusRepository;
import fev.management.repository.LoginRepository;
import fev.management.repository.LoginRoleRepository;
import fev.management.repository.MemberPositionRepository;
import fev.management.repository.MemberRepository;

@Controller
public class MemberPositionController implements BaseController<FevMemberPosition> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    private final String path = "/members/positions";

    @Autowired
    MemberPositionRepository memberPositionRepository;

    // GET
    // Display all album
    @GetMapping(path)
    @ResponseBody
    @Override
    public List<FevMemberPosition> getAll() {
        // TODO Auto-generated method stub
        return (List<FevMemberPosition>) memberPositionRepository.findAll();
    }

    // Get Album By ID
    @GetMapping(path + "/{id}")
    @ResponseBody
    @Override
    public Optional<FevMemberPosition> getByID(@PathVariable("id") int id) {
        // TODO Auto-generated method stub
        return memberPositionRepository.findById(id);
    }

    @GetMapping(path + "/count")
    @ResponseBody
    @Override
    public long getCount() {
        // TODO Auto-generated method stub
        return memberPositionRepository.count();
    }

    // Get Event By ID
    @DeleteMapping(path + "/{id}")
    @ResponseBody
    @Override
    public void deleteByID(@PathVariable("id") int id) {
        memberPositionRepository.deleteById(id);

    }

    @PostMapping(path + "/{memPos}")
    @ResponseBody
    @Override
    public void create(@PathVariable("memPos") FevMemberPosition object) {
        // TODO Auto-generated method stub
        memberPositionRepository.save(object);
    }

    // Create new Event
    @PutMapping(path + "/{memPos}")
    @ResponseBody
    @Override
    public void update(@PathVariable("memPos") FevMemberPosition object) {
        // TODO Auto-generated method stub
        memberPositionRepository.save(object);
    }
}