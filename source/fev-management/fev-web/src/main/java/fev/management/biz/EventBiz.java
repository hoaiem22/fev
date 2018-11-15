package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevEvent;

public interface EventBiz {
    boolean updateData(Iterable<FevEvent> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevEvent, Integer> getRepo();
}
