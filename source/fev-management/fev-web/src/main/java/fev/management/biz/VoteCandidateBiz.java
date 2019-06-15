package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevVoteCandidate;

public interface VoteCandidateBiz {

    boolean updateData(Iterable<FevVoteCandidate> voteCan, List<Integer> tobeDeletedIds);

    CrudRepository<FevVoteCandidate, Integer> getRepo();
}
