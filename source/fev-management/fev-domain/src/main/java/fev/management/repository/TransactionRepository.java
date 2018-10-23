package fev.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevEvent;
import fev.management.entity.FevTransaction;

@Repository
public interface TransactionRepository extends CrudRepository<FevTransaction, Integer> {

}
