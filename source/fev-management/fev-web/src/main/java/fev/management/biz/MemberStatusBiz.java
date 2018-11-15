package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevMemberStatus;

public interface MemberStatusBiz {
    boolean updateData(Iterable<FevMemberStatus> list, List<Integer> tobeDeletedIds);

    CrudRepository<FevMemberStatus, Integer> getRepo();
}
