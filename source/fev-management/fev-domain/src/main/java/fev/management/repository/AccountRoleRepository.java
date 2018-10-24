package fev.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevAccountRole;

@Repository
public interface AccountRoleRepository extends CrudRepository<FevAccountRole, Integer> {

}
