package fev.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevEvent;
import fev.management.entity.FevInventory;

@Repository
public interface InventoryRepository extends CrudRepository<FevInventory, Integer> {

}
