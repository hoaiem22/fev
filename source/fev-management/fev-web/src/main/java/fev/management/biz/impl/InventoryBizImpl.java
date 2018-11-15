package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.InventoryBiz;
import fev.management.entity.FevInventory;
import fev.management.entity.FevInventoryItem;
import fev.management.entity.FevInventoryStatus;
import fev.management.entity.FevMember;
import fev.management.repository.InventoryItemRepository;
import fev.management.repository.InventoryRepository;
import fev.management.repository.InventoryStatusRepository;
import fev.management.repository.MemberRepository;

@Service
public class InventoryBizImpl implements InventoryBiz{

    @Autowired
    InventoryRepository inventoryRepo;
    
    @Autowired
    InventoryItemRepository inventItemRepo;

    @Autowired
    MemberRepository memberRepo;
    
    @Autowired
    InventoryStatusRepository inventStatusRepo;
    
    @Override
    public boolean updateData(Iterable<FevInventory> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        FevInventoryItem fevInventoryItem;
        FevMember fevMember;
        FevInventoryStatus fevInventoryStatus;
        for (FevInventory fevInventory : list) {
            //if item is null, then update item
            if(fevInventory.getItem() != null && fevInventory.getItem().getId() == null) {
                fevInventoryItem = inventItemRepo.findByName(fevInventory.getItem().getName());
                fevInventory.setItem(fevInventoryItem);
            }
            //if member is null, then update member
            if(fevInventory.getHolder() != null && fevInventory.getHolder().getId() == null) {
                fevMember = memberRepo.findByFullname(fevInventory.getHolder().getFullname());
                fevInventory.setHolder(fevMember);
            }
            //if item status is null, then update item status
            if(fevInventory.getStatus() != null && fevInventory.getStatus().getId() == null) {
                fevInventoryStatus = inventStatusRepo.findByStatus(fevInventory.getStatus().getStatus());
                fevInventory.setStatus(fevInventoryStatus);
            }
        }
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                inventoryRepo.deleteById(deleteId);
            });
        }
        inventoryRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevInventory, Integer> getRepo() {
        // TODO Auto-generated method stub
        return inventoryRepo;
    }
    
    
}
