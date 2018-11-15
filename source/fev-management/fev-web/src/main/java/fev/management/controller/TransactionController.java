package fev.management.controller;

import java.util.ArrayList;
import java.util.Date;
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

import fev.management.biz.impl.TransactionBizImpl;
import fev.management.dto.MemberCast;
import fev.management.dto.TransactionCast;
import fev.management.entity.FevTransaction;
import fev.management.entity.FevTransactionType;
import fev.management.model.TransactionModel;
import fev.management.model.TransactionTypeModel;
import fev.management.repository.TransactionRepository;
import fev.management.util.AppUtil;

@Controller
public class TransactionController {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(TransactionController.class);
    
    @Autowired
    TransactionRepository transRepo;
    
    @Autowired
    TransactionBizImpl transBizImpl;
    
    @GetMapping("/management/transaction")
    public String transaction() {
        return "management/transaction";
    }

    @GetMapping("/management/transaction/loadHand")
    @ResponseBody
    public List<TransactionCast> loadData() {
        List<Object[]> list = transRepo.getAll();
        List<TransactionCast> listTransaction = new ArrayList<>();
        for (Object[] objects : list) {
            int id = (int) objects[0];
            String type = (String) objects[1];
            String content = String.valueOf(objects[2]);
            int money = (int) objects[3];
            String event = (String) objects[4];
            String burden = (String) objects[5];
            String note = (String) objects[6];
            listTransaction.add(new TransactionCast(id, type, content, money, event, burden, note));
        }

        return (List<TransactionCast>) listTransaction;
    }
    
    @PostMapping("/management/transaction/save")
    @ResponseBody
    public List<FevTransaction> saveMemberStatus(@Valid @RequestBody TransactionModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save transaction...");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevTransaction> entities = AppUtil.parseTransaction(data);

            transBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevTransaction> transactions = (List<FevTransaction>) transRepo.findAll();

        return transactions;

    }
}
