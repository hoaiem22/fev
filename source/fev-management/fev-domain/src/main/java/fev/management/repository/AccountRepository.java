package fev.management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fev.management.entity.FevAccount;

@Repository
public interface AccountRepository extends CrudRepository<FevAccount, Integer> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM fptueventclub.fev_account\r\n" + 
            "where username = :username and password = :password")
    FevAccount checkLogin(@Param("username") String username, @Param("password") String password);
}
