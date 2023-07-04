package spring.BshopServer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import spring.BshopServer.entity.Account;
import spring.BshopServer.form.AuthChangePasswordForm;
import spring.BshopServer.form.createForm.AccountCreateForm;
import spring.BshopServer.form.updateForm.AccountUpdateForm;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    Page<Account> findAll(Pageable pageable);

    Account findById(int id);

    void create(AccountCreateForm form);

    void update(AccountUpdateForm form);

    void deleteById(int id);

    boolean existsById(int id);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    Account findByUsername(String username);

    void deleteAll(List<Integer> ids);

    @Transactional
    void changePassword(AuthChangePasswordForm form);
}
