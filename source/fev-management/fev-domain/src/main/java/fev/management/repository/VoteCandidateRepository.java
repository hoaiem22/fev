package fev.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
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
    
	// Set key status and set number of vote used
		@Transactional
		@Modifying
		@Query(nativeQuery = true, value = "UPDATE `fptueventclub`.`fev_vote_candidate` SET `total`= ( total + :prio ) WHERE `member` = :id and `group`= :gr and `position` = :pos")
		void updateTotal(@Param("id") int id, @Param("prio") int prio, @Param("gr") int gr, @Param("pos") int pos);

}
