package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevEventMember;

public interface EventMemberBiz {
    boolean updateData(Iterable<FevEventMember> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevEventMember, Integer> getRepo();
}
