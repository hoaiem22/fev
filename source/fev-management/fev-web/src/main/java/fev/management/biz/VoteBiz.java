package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevVote;

public interface VoteBiz {

    boolean updateData(Iterable<FevVote> vote, List<Integer> tobeDeletedIds);

    CrudRepository<FevVote, Integer> getRepo();
}
