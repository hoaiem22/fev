package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevTransactionType;

public interface TransactionTypeBiz {
    boolean updateData(Iterable<FevTransactionType> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevTransactionType, Integer> getRepo();
}
