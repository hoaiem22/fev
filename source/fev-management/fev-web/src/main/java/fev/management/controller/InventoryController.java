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

import fev.management.biz.impl.InventoryBizImpl;
import fev.management.dto.InventoryCast;
import fev.management.entity.FevInventory;
import fev.management.entity.FevMember;
import fev.management.model.InventoryModel;
import fev.management.repository.InventoryRepository;
import fev.management.util.AppUtil;

@Controller
public class InventoryController {
    
    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(InventoryController.class);
    
    @Autowired
    InventoryRepository inventoryRepo;
    
    @Autowired
    InventoryBizImpl inventoryBizImpl;
    
    @GetMapping("/management/inventory")
    public String member() {
        return "management/inventory";
    }
    
    @GetMapping("/management/inventory/loadHand")
    @ResponseBody
    public List<InventoryCast> loadData() {
        LOG.info("Data: ");
        List<Object[]> list = inventoryRepo.getAll();
        List<InventoryCast> listInventory = new ArrayList<>();
        for (Object[] objects : list) {
            int id = (int) objects[0];
            String item = (String) objects[1];
            int quantity = (int) objects[2];
            String holder = String.valueOf(objects[3]);
            String status = (String) objects[4];
            String note = (String) objects[5];
            listInventory.add(new InventoryCast(id, item, quantity, holder, status, note));
        }

        return (List<InventoryCast>) listInventory;
    }
    
    @PostMapping("/management/inventory/save")
    @ResponseBody
    public List<FevInventory> saveTeam(@Valid @RequestBody InventoryModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save inventory...");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevInventory> entities = AppUtil.parseInventory(data);

            inventoryBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevInventory> inventories = (List<FevInventory>) inventoryRepo.findAll();

        return inventories;

    }
}
