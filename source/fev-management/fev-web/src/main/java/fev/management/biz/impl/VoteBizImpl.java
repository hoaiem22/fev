package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.MemberGroupBiz;
import fev.management.biz.MemberPositionBiz;
import fev.management.biz.VoteBiz;
import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevVote;
import fev.management.repository.MemberGroupRepository;
import fev.management.repository.MemberPositionRepository;
import fev.management.repository.VoteRepository;

@Service
public class VoteBizImpl implements VoteBiz{

    @Autowired
    VoteRepository voteRepo;
    
    @Override
    public boolean updateData(Iterable<FevVote> list, List<Integer> tobeDeletedIds) {
     // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
            	voteRepo.deleteById(deleteId);
            });
        }
        voteRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevVote, Integer> getRepo() {
        // TODO Auto-generated method stub
        return voteRepo;
    }

}
