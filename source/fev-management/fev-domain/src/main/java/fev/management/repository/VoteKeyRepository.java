package fev.management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevVoteKey;

@Repository
public interface VoteKeyRepository extends CrudRepository<FevVoteKey, Integer> {
 
	//Find key active by name
    @Query(nativeQuery = true, value = "Select id, `key`, priority, is_active, note From fptueventclub.fev_vote_key Where is_active = 1 and `key` = :key")
    FevVoteKey findByName(@Param("key") String key);
}
