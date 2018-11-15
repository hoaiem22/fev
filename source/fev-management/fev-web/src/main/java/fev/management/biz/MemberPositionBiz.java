package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevMemberPosition;

public interface MemberPositionBiz {

    boolean updateData(Iterable<FevMemberPosition> report, List<Integer> tobeDeletedIds);

    CrudRepository<FevMemberPosition, Integer> getRepo();
}
