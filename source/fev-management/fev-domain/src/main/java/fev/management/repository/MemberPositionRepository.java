package fev.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevEvent;
import fev.management.entity.FevMemberPosition;

@Repository
public interface MemberPositionRepository extends CrudRepository<FevMemberPosition, Integer> {

}
