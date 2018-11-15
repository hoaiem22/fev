package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.AccountBiz;
import fev.management.entity.FevAccount;
import fev.management.entity.FevAccountRole;
import fev.management.repository.AccountRepository;
import fev.management.repository.AccountRoleRepository;

@Service
public class AccountBizImpl implements AccountBiz{

    @Autowired
    AccountRepository accRepo;
    
    @Autowired
    AccountRoleRepository accRoleRepo;
    
    @Override
    public boolean updateData(Iterable<FevAccount> list, List<Integer> tobeDeletedIds) {
        FevAccountRole fevAccountRole;
        
        for (FevAccount fevAccount : list) {
            if(fevAccount.getRole() != null & fevAccount.getRole().getId() == null) {
                fevAccountRole = accRoleRepo.findByRole(fevAccount.getRole().getRole());
                fevAccount.setRole(fevAccountRole);
            }
        }
        
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                accRepo.deleteById(deleteId);
            });
        }

        accRepo.saveAll(list);
        
        return false;
    }

    @Override
    public CrudRepository<FevAccount, Integer> getRepo() {
        // TODO Auto-generated method stub
        return accRepo;
    }

}
