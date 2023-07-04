package spring.BshopServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.BshopServer.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);

    boolean existsByUsername(String name);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Account SET password =:password WHERE username =:username")
    String changePassword(@Param("username") String username, @Param("password") String password);
}
