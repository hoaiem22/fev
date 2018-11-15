package fev.management.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fev.management.biz.FeedbackBiz;
import fev.management.entity.FevFeedback;
import fev.management.entity.FevFeedbackStatus;
import fev.management.repository.FeedbackRepository;
import fev.management.repository.FeedbackStatusRepository;

@Service
public class FeedbackBizImpl implements FeedbackBiz{
    
    @Autowired
    FeedbackRepository feedbackRepo;
    
    @Autowired
    FeedbackStatusRepository feedbackStatusRepo;

    @Override
    public boolean updateData(Iterable<FevFeedback> list, List<Integer> tobeDeletedIds) {
        // TODO Auto-generated method stub
        FevFeedbackStatus fevFeedbackStatus;
        for (FevFeedback fevFeedback : list) {
            //Update feedback status
            if(fevFeedback.getStatus() != null && fevFeedback.getStatus().getId() == null) {
                fevFeedbackStatus = feedbackStatusRepo.findByStatus(fevFeedback.getStatus().getStatus());
                fevFeedback.setStatus(fevFeedbackStatus);
            }
        }
        if (tobeDeletedIds != null) {
            tobeDeletedIds.forEach(deleteId -> {
                feedbackRepo.deleteById(deleteId);
            });
        }
        feedbackRepo.saveAll(list);

        return true;
    }

    @Override
    public CrudRepository<FevFeedback, Integer> getRepo() {
        // TODO Auto-generated method stub
        return feedbackRepo;
    }
    
}
