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

import fev.management.biz.impl.TransactionTypeBizImpl;
import fev.management.entity.FevMemberStatus;
import fev.management.entity.FevTransactionType;
import fev.management.model.MemberStatusModel;
import fev.management.model.TransactionTypeModel;
import fev.management.repository.TransactionRepository;
import fev.management.repository.TransactionTypeRepository;
import fev.management.util.AppUtil;

@Controller
public class TransactionTypeController {
    
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(TransactionTypeController.class);
    
    @Autowired
    TransactionTypeRepository transTypeRepo;
    
    @Autowired
    TransactionTypeBizImpl transTypeBizImpl;
    
    @GetMapping("/management/transaction/type")
    public String transactionType() {
        return "management/transaction_type";
    }

    @GetMapping("/management/transaction/type/loadHand")
    @ResponseBody
    public List<FevTransactionType> loadData() {
        LOG.info("Data: " );
        return (List<FevTransactionType>) transTypeRepo.findAll();
    }
    
    @PostMapping("/management/transaction/type/save")
    @ResponseBody
    public List<FevTransactionType> saveMemberStatus(@Valid @RequestBody TransactionTypeModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevTransactionType> entities = AppUtil.parseTransactionType(data);

            transTypeBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevTransactionType> transTypes = (List<FevTransactionType>) transTypeRepo.findAll();

        return transTypes;

    }
}
