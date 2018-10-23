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
import fev.management.entity.FevTransaction;
import fev.management.entity.FevTransactionType;
import fev.management.repository.InventoryStatusRepository;
import fev.management.repository.LoginRepository;
import fev.management.repository.LoginRoleRepository;
import fev.management.repository.MemberRepository;
import fev.management.repository.TransactionRepository;
import fev.management.repository.TransactionTypeRepository;

@Controller
public class TracsactionTypeController implements BaseController<FevTransactionType> {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(EventController.class);

    private final String path = "/transactions/types";

    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    // GET
    // Display all album
    @GetMapping(path)
    @ResponseBody
    @Override
    public List<FevTransactionType> getAll() {
        // TODO Auto-generated method stub
        return (List<FevTransactionType>) transactionTypeRepository.findAll();
    }

    // Get Album By ID
    @GetMapping(path + "/{id}")
    @ResponseBody
    @Override
    public Optional<FevTransactionType> getByID(@PathVariable("id") int id) {
        // TODO Auto-generated method stub
        return transactionTypeRepository.findById(id);
    }

    @GetMapping(path + "/count")
    @ResponseBody
    @Override
    public long getCount() {
        // TODO Auto-generated method stub
        return transactionTypeRepository.count();
    }

    // Get Event By ID
    @DeleteMapping(path + "/{id}")
    @ResponseBody
    @Override
    public void deleteByID(@PathVariable("id") int id) {
        transactionTypeRepository.deleteById(id);

    }

    @PostMapping(path + "/{transType}")
    @ResponseBody
    @Override
    public void create(@PathVariable("transType") FevTransactionType object) {
        // TODO Auto-generated method stub
        transactionTypeRepository.save(object);
    }

    // Create new Event
    @PutMapping(path + "/{transType}")
    @ResponseBody
    @Override
    public void update(@PathVariable("transType") FevTransactionType object) {
        // TODO Auto-generated method stub
        transactionTypeRepository.save(object);
    }
}