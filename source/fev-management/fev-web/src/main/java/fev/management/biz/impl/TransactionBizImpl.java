package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.TransactionBiz;
import fev.management.entity.FevEvent;
import fev.management.entity.FevMember;
import fev.management.entity.FevTransaction;
import fev.management.entity.FevTransactionType;
import fev.management.repository.EventRepository;
import fev.management.repository.MemberRepository;
import fev.management.repository.TransactionRepository;
import fev.management.repository.TransactionTypeRepository;

@Service
public class TransactionBizImpl implements TransactionBiz{

    @Autowired
    TransactionRepository transRepo;
    
    @Autowired
    TransactionTypeRepository transTypeRepo;
    
    @Autowired
    EventRepository eventRepo;
    
    @Autowired
    MemberRepository memberRepo;

    @Override
    public boolean updateData(Iterable<FevTransaction> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        FevTransactionType fevTransactionType;
        FevEvent fevEvent;
        FevMember fevMember;
        for (FevTransaction fevTransaction : list) {
            //Update transaction type
            if(fevTransaction.getType() != null && fevTransaction.getType().getId() == null) {
                fevTransactionType = transTypeRepo.findByType(fevTransaction.getType().getType());
                fevTransaction.setType(fevTransactionType);
            }
            //Update event
            if(fevTransaction.getEvent() != null && fevTransaction.getEvent().getId() == null) {
                fevEvent = eventRepo.findByName(fevTransaction.getEvent().getName());
                fevTransaction.setEvent(fevEvent);
            }
            //Update member who's burden
            if(fevTransaction.getBurden() != null && fevTransaction.getBurden().getId() == null) {
                fevMember = memberRepo.findByFullname(fevTransaction.getBurden().getFullname());
                fevTransaction.setBurden(fevMember);
            }
        }
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                transRepo.deleteById(deleteId);
            });
        }
        transRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevTransaction, Integer> getRepo() {
        // TODO Auto-generated method stub
        return transRepo;
    }
    
}
