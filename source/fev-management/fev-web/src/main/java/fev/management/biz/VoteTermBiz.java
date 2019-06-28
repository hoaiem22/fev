package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevVote;
import fev.management.entity.FevVoteTerm;

public interface VoteTermBiz {

	boolean updateData(Iterable<FevVoteTerm> vote, List<Integer> tobeDeletedIds);

	CrudRepository<FevVoteTerm, Integer> getRepo();
}
