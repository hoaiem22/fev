package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevFeedbackStatus;

public interface FeedbackStatusBiz {
    boolean updateData(Iterable<FevFeedbackStatus> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevFeedbackStatus, Integer> getRepo();
}
