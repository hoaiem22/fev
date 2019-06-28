package fev.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevEvent;
import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;
import fev.management.entity.FevMemberStatus;
import fev.management.entity.FevVote;

@Repository
public interface MemberGroupRepository extends CrudRepository<FevMemberGroup, Integer> {
    
	@Query(nativeQuery = true, value = "select * from fptueventclub.fev_member_group where `group` = :gr")
    FevMemberGroup findByGroup(@Param("gr") String gr);
	
	@Query(nativeQuery = true, value = "SELECT `group` FROM fptueventclub.fev_member_group")
    List<String> getAllName();
}
