package fev.management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevEvent;
import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevVoteCandidate;
import fev.management.entity.FevVoteKey;

@Repository
public interface VoteCandidateRepository extends CrudRepository<FevVoteCandidate, Integer> {
    
}
