package fev.management.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fev.management.entity.FevAccount;

public interface AccountBiz {
    boolean updateData(Iterable<FevAccount> account, List<Integer> tobeDeletedIds);

    CrudRepository<FevAccount, Integer> getRepo();
}
