package fev.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevVoteKey;
import fev.management.entity.FevVoteTerm;

@Repository
public interface VoteTermRepository extends CrudRepository<FevVoteTerm, Integer> {

}
