package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevMember;

public interface MemberBiz {
    boolean updateData(Iterable<FevMember> member, List<Integer> tobeDeletedIds);

    CrudRepository<FevMember, Integer> getRepo();
}
