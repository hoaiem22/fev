package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevVoteKey;

public interface VoteKeyBiz {

    boolean updateData(Iterable<FevVoteKey> voteKey, List<Integer> tobeDeletedIds);

    CrudRepository<FevVoteKey, Integer> getRepo();
}
