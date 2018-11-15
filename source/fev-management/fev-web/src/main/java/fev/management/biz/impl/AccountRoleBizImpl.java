package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.AccountRoleBiz;
import fev.management.entity.FevAccountRole;
import fev.management.repository.AccountRoleRepository;

@Service
public class AccountRoleBizImpl implements AccountRoleBiz{

    @Autowired
    AccountRoleRepository accountRoleRepository;
    
    @Override
    public boolean updateData(Iterable<FevAccountRole> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                accountRoleRepository.deleteById(deleteId);
            });
        }

        accountRoleRepository.saveAll(list);

        return true;

    }

    @Override
    public CrudRepository<FevAccountRole, Integer> getRepo() {
        // TODO Auto-generated method stub
        return accountRoleRepository;
    }

}
