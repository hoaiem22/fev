package fev.management.controller;

import java.util.ArrayList;
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

import fev.management.biz.impl.AccountBizImpl;
import fev.management.dto.AccountCast;
import fev.management.entity.FevAccount;
import fev.management.model.AccountModel;
import fev.management.repository.AccountRepository;
import fev.management.util.AppUtil;

@Controller
public class AccountController {
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(AccountController.class);
    
    @Autowired
    AccountRepository accountRepo;
    
    @Autowired
    AccountBizImpl accBizImpl;
    
    @GetMapping("/management/account")
    public String account() {
        return "management/account";
    }
    
    @GetMapping("/management/account/loadHand")
    @ResponseBody
    public List<AccountCast> loadData() {
        List<Object[]> list = accountRepo.getAll();
        List<AccountCast> listAccount = new ArrayList<>();
        for (Object[] object : list) {
            int id = (int) object[0];
            String username = (String) object[1];
            String password = (String) object[2];
            String role = (String) object[3];
            String note = (String) object[4];
            listAccount.add(new AccountCast(id, username, password, role, note));
        }
        
        return (List<AccountCast>) listAccount;
    }
    
    @PostMapping("/management/account/saveAccount")
    @ResponseBody
    public List<FevAccount> saveTeam(@Valid @RequestBody AccountModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevAccount> entities = AppUtil.parseAccount(data);

            accBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevAccount> list = (List<FevAccount>) accountRepo.findAll();

        return list;

    }
}
