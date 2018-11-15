package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.FeedbackStatusBiz;
import fev.management.entity.FevFeedbackStatus;
import fev.management.repository.FeedbackStatusRepository;

@Service
public class FeedbackStatusBizImpl implements FeedbackStatusBiz{

    @Autowired
    FeedbackStatusRepository fbStatusRepo;

    @Override
    public boolean updateData(Iterable<FevFeedbackStatus> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                fbStatusRepo.deleteById(deleteId);
            });
        }
        fbStatusRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevFeedbackStatus, Integer> getRepo() {
        // TODO Auto-generated method stub
        return fbStatusRepo;
    }
    
}
