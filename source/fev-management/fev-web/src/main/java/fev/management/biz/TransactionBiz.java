package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevTransaction;

public interface TransactionBiz {
    boolean updateData(Iterable<FevTransaction> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevTransaction, Integer> getRepo();
}
