package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.InventoryItemBiz;
import fev.management.entity.FevInventoryItem;
import fev.management.repository.InventoryItemRepository;

@Service
public class InventoryItemBizImpl implements InventoryItemBiz {

    @Autowired
    InventoryItemRepository inventItemRepo;
    
    @Override
    public boolean updateData(Iterable<FevInventoryItem> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                inventItemRepo.deleteById(deleteId);
            });
        }
        inventItemRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevInventoryItem, Integer> getRepo() {
        // TODO Auto-generated method stub
        return inventItemRepo;
    }

}
