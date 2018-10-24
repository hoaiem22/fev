package fev.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevAccount;

@Repository
public interface AccountRepository extends CrudRepository<FevAccount, Integer> {

}
