package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.TransactionTypeBiz;
import fev.management.entity.FevTransactionType;
import fev.management.repository.TransactionTypeRepository;

@Service
public class TransactionTypeBizImpl implements TransactionTypeBiz{

    @Autowired
    TransactionTypeRepository transTypeRepo;

    @Override
    public boolean updateData(Iterable<FevTransactionType> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                transTypeRepo.deleteById(deleteId);
            });
        }
        transTypeRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevTransactionType, Integer> getRepo() {
        // TODO Auto-generated method stub
        return transTypeRepo;
    }
}
