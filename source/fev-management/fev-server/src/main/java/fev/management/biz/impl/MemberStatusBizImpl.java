package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.MemberStatusBiz;
import fev.management.entity.FevMemberStatus;
import fev.management.repository.MemberStatusRepository;

@Service
public class MemberStatusBizImpl implements MemberStatusBiz{

    @Autowired
    MemberStatusRepository memStaRepo;
    
    @Override
    public boolean updateData(Iterable<FevMemberStatus> list, List<Integer> tobeDeletedIds) {
     // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                memStaRepo.deleteById(deleteId);
            });
        }
        memStaRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevMemberStatus, Integer> getRepo() {
        // TODO Auto-generated method stub
        return memStaRepo;
    }

}
