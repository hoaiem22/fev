package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.MemberPositionBiz;
import fev.management.entity.FevMemberPosition;
import fev.management.repository.MemberPositionRepository;

@Service
public class MemberPositionBizImpl implements MemberPositionBiz{

    @Autowired
    MemberPositionRepository memPosRepo;
    
    @Override
    public boolean updateData(Iterable<FevMemberPosition> list, List<Integer> tobeDeletedIds) {
     // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                memPosRepo.deleteById(deleteId);
            });
        }
        memPosRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevMemberPosition, Integer> getRepo() {
        // TODO Auto-generated method stub
        return memPosRepo;
    }

}
