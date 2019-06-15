package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevMemberGroup;
import fev.management.entity.FevMemberPosition;

public interface MemberGroupBiz {

    boolean updateData(Iterable<FevMemberGroup> group, List<Integer> tobeDeletedIds);

    CrudRepository<FevMemberGroup, Integer> getRepo();
}
