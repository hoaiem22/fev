package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevInventoryItem;

public interface InventoryItemBiz {
    boolean updateData(Iterable<FevInventoryItem> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevInventoryItem, Integer> getRepo();
}
