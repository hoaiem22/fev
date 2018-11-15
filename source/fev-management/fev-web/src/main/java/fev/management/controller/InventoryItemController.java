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

import fev.management.biz.impl.InventoryItemBizImpl;
import fev.management.entity.FevInventoryItem;
import fev.management.model.InventoryItemModel;
import fev.management.repository.InventoryItemRepository;
import fev.management.util.AppUtil;

@Controller
public class InventoryItemController {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(InventoryItemController.class);
    
    @Autowired
    InventoryItemRepository inventItemRepo;
    
    @Autowired
    InventoryItemBizImpl inventItemBizImpl;
    
    @GetMapping("/management/inventory/item")
    public String inventory_item() {
        return "management/inventory_item";
    }

    @GetMapping("/management/inventory/item/loadHand")
    @ResponseBody
    public List<FevInventoryItem> loadData() {
        
        return (List<FevInventoryItem>) inventItemRepo.findAll();
    }

    @PostMapping("/management/inventory/item/save")
    @ResponseBody
    public List<FevInventoryItem> saveInventoryStatus(@Valid @RequestBody InventoryItemModel data, Errors errors,
            HttpServletRequest request) {
        LOG.info("save account role....");

        // If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            LOG.error(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            LOG.info("step1");
            return null;
        } else {

            Iterable<FevInventoryItem> entities = AppUtil.parseInventoryItem(data);

            inventItemBizImpl.updateData(entities, data.getDeletedIds());
        }

        // Reload data from db
        List<FevInventoryItem> inventItems = (List<FevInventoryItem>) inventItemRepo.findAll();

        return inventItems;

    }
}
