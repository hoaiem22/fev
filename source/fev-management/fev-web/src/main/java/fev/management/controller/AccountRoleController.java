package fev.management.controller;

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

import fev.management.biz.impl.AccountRoleBizImpl;
import fev.management.entity.FevAccountRole;
import fev.management.model.AccountRoleModel;
import fev.management.repository.AccountRoleRepository;
@Controller
public class AccountRoleController {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(AccountRoleController.class);
    
    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Autowired
    AccountRoleBizImpl accRoleBiz;
    
    @GetMapping("/account/role")
    public String account_role() {
        return "management/account_role";
    }

    @GetMapping("/account/role/loadHand")
    @ResponseBody
    public List<FevAccountRole> loadData() {
        LOG.info("Data: " );
        return (List<FevAccountRole>) accountRoleRepository.findAll();
    }
    
    @PostMapping("/account/role/saveAccountRole")
    @ResponseBody
    public List<FevAccountRole> saveTeam(@Valid @RequestBody AccountRoleModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevAccountRole> entities = fev.management.util.AppUtil.parseAccountRole(data);

            accRoleBiz.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevAccountRole> account = (List<FevAccountRole>) accountRoleRepository.findAll();

        return account;

    }
}
