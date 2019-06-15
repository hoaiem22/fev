package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.MemberGroupBiz;
import fev.management.biz.MemberPositionBiz;
import fev.management.biz.VoteBiz;
import fev.management.biz.VoteCandidateBiz;
import fev.management.biz.VoteKeyBiz;
import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevVote;
import fev.management.entity.FevVoteCandidate;
import fev.management.entity.FevVoteKey;
import fev.management.repository.MemberGroupRepository;
import fev.management.repository.MemberPositionRepository;
import fev.management.repository.VoteCandidateRepository;
import fev.management.repository.VoteKeyRepository;
import fev.management.repository.VoteRepository;

@Service
public class VoteCandidateBizImpl implements VoteCandidateBiz{

    @Autowired
    VoteCandidateRepository voteCandidateRepo;
    
    @Override
    public boolean updateData(Iterable<FevVoteCandidate> list, List<Integer> tobeDeletedIds) {
     // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
            	voteCandidateRepo.deleteById(deleteId);
            });
        }
        voteCandidateRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevVoteCandidate, Integer> getRepo() {
        // TODO Auto-generated method stub
        return voteCandidateRepo;
    }

}
