package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevAccountRole;

public interface AccountRoleBiz {
    boolean updateData(Iterable<FevAccountRole> report, List<Integer> tobeDeletedIds);

    CrudRepository<FevAccountRole, Integer> getRepo();
}
