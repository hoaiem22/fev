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
import fev.management.repository.InventoryStatusRepository;
import fev.management.repository.LoginRepository;
import fev.management.repository.LoginRoleRepository;
import fev.management.repository.MemberRepository;

@Controller
public class MemberController implements BaseController<FevMember> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    private final String path = "/members";

    @Autowired
    MemberRepository memberRepository;

    // GET
    // Display all album
    @GetMapping(path)
    @ResponseBody
    @Override
    public List<FevMember> getAll() {
        // TODO Auto-generated method stub
        return (List<FevMember>) memberRepository.findAll();
    }

    // Get Album By ID
    @GetMapping(path + "/{id}")
    @ResponseBody
    @Override
    public Optional<FevMember> getByID(@PathVariable("id") int id) {
        // TODO Auto-generated method stub
        return memberRepository.findById(id);
    }

    @GetMapping(path + "/count")
    @ResponseBody
    @Override
    public long getCount() {
        // TODO Auto-generated method stub
        return memberRepository.count();
    }

    // Get Event By ID
    @DeleteMapping(path + "/{id}")
    @ResponseBody
    @Override
    public void deleteByID(@PathVariable("id") int id) {
        memberRepository.deleteById(id);

    }

    @PostMapping(path + "/{member}")
    @ResponseBody
    @Override
    public void create(@PathVariable("member") FevMember object) {
        // TODO Auto-generated method stub
        memberRepository.save(object);
    }

    // Create new Event
    @PutMapping(path + "/{member}")
    @ResponseBody
    @Override
    public void update(@PathVariable("member") FevMember object) {
        // TODO Auto-generated method stub
        memberRepository.save(object);
    }
}