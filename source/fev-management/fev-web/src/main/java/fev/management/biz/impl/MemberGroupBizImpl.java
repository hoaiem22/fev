package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.MemberGroupBiz;
import fev.management.biz.MemberPositionBiz;
import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;
import fev.management.repository.MemberGroupRepository;
import fev.management.repository.MemberPositionRepository;

@Service
public class MemberGroupBizImpl implements MemberGroupBiz{

    @Autowired
    MemberGroupRepository memGroupRepo;
    
    @Override
    public boolean updateData(Iterable<FevMemberGroup> list, List<Integer> tobeDeletedIds) {
     // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
            	memGroupRepo.deleteById(deleteId);
            });
        }
        memGroupRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevMemberGroup, Integer> getRepo() {
        // TODO Auto-generated method stub
        return memGroupRepo;
    }

}
