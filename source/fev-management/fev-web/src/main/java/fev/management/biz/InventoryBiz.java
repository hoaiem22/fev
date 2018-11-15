package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevInventory;

public interface InventoryBiz {
    boolean updateData(Iterable<FevInventory> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevInventory, Integer> getRepo();
}
