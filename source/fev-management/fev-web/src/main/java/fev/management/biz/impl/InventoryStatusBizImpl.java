package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.InventoryStatusBiz;
import fev.management.entity.FevInventoryStatus;
import fev.management.repository.InventoryStatusRepository;

@Service
public class InventoryStatusBizImpl implements InventoryStatusBiz{

    @Autowired
    InventoryStatusRepository inventStatusRepo;
    
    @Override
    public boolean updateData(Iterable<FevInventoryStatus> list, List<Integer> tobeDeletedIds) {
     // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                inventStatusRepo.deleteById(deleteId);
            });
        }
        inventStatusRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevInventoryStatus, Integer> getRepo() {
        // TODO Auto-generated method stub
        return inventStatusRepo;
    }

}
