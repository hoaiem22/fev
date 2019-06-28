package fev.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevAccount;
import fev.management.entity.FevEvent;
import fev.management.entity.FevMember;

@Repository
public interface MemberRepository extends CrudRepository<FevMember, Integer> {

	// Get all data with custome query
	@Query(nativeQuery = true, value = "SELECT m.id, m.fullname, m.studentID, m.birthdate, m.sex, m.address, m.phone, p.position, s.status, m.point, m.note\r\n"
			+ "FROM fev_member m\r\n" + "inner join fev_member_position p on m.position = p.id\r\n"
			+ "inner join fev_member_status s on m.status = s.id")
	List<Object[]> getAll();

	// Find Member by fullname
	@Query(nativeQuery = true, value = "select * from fev_member where fullname = :fullname")
	FevMember findByFullname(@Param("fullname") String fullname);

	// Find Candidate by group and position
	@Query(nativeQuery = true, value = "SELECT * FROM fptueventclub.fev_member\r\n"
			+ "where id in (SELECT member FROM fptueventclub.fev_vote_candidate\r\n"
			+ "where `group` = (SELECT id FROM fptueventclub.fev_member_group\r\n" + "where `group` = :group) \r\n"
			+ "and `position` = (SELECT id FROM fptueventclub.fev_member_position where `position` = :position));")
	List<FevMember> getCandidates(@Param("group") String group, @Param("position") String position);

	// Find Member by id
	@Query(nativeQuery = true, value = "select * from fev_member where id = :id")
	FevMember findByID(@Param("id") int id);
}
