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

import fev.management.biz.impl.InventoryStatusBizImpl;
import fev.management.entity.FevInventoryStatus;
import fev.management.entity.FevMemberStatus;
import fev.management.model.InventoryStatusModel;
import fev.management.model.MemberStatusModel;
import fev.management.repository.InventoryStatusRepository;
import fev.management.util.AppUtil;

@Controller
public class InventoryStatusController {
    
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(InventoryStatusController.class);
    
    @Autowired
    InventoryStatusRepository inventStatusRepo;

    @Autowired
    InventoryStatusBizImpl iventStatusBizImpl;

    @GetMapping("/management/inventory/status")
    public String memberStatus() {
        return "management/inventory_status";
    }

    @GetMapping("/management/inventory/status/loadHand")
    @ResponseBody
    public List<FevInventoryStatus> loadData() {
        LOG.info("Data: ");
        return (List<FevInventoryStatus>) inventStatusRepo.findAll();
    }

    @PostMapping("/management/inventory/status/saveMemberStatus")
    @ResponseBody
    public List<FevInventoryStatus> saveInventoryStatus(@Valid @RequestBody InventoryStatusModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevInventoryStatus> entities = AppUtil.parseInventoryStatus(data);

            iventStatusBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevInventoryStatus> inventStatuss = (List<FevInventoryStatus>) inventStatusRepo.findAll();

        return inventStatuss;

    }
}
