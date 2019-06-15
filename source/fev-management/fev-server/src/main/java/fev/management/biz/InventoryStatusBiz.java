package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevInventoryStatus;

public interface InventoryStatusBiz {
    boolean updateData(Iterable<FevInventoryStatus> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevInventoryStatus, Integer> getRepo();
}
