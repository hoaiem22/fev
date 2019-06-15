package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevFeedback;

public interface FeedbackBiz {
    boolean updateData(Iterable<FevFeedback> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevFeedback, Integer> getRepo();
}
