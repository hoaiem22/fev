package fev.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevEvent;

@Repository
public interface EventRepository extends CrudRepository<FevEvent, Integer> {

}
