package spring.BshopServer.service.imp;

import spring.BshopServer.entity.Account;


import spring.BshopServer.repository.IAccountRepository;
import spring.BshopServer.form.createForm.AccountCreateForm;

import spring.BshopServer.form.updateForm.AccountUpdateForm;
import spring.BshopServer.form.AuthChangePasswordForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService implements spring.BshopServer.service.IAccountService {
    @Autowired
    private IAccountRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Page<Account> findAll(Pageable pageable) {
        return repository.findAll( pageable);
    }


    @Override
    public Account findById(int id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    public void create(AccountCreateForm form) {
        String hash = passwordEncoder.encode(form.getPassword());
        Account account = mapper.map(form, Account.class);
        account.setPassword(hash);
        repository.save(account);
    }


    @Override
    public void update(AccountUpdateForm form) {
        repository.save(mapper.map(form, Account.class));
    }


    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }


    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(
                account.getUsername(),
                account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getRole().toString())
        );
    }


    @Override
    public Account findByUsername(String username) {
        return repository.findByUsername(username);
    }


    @Override
    public void deleteAll(List<Integer> ids) {
        repository.deleteAllById(ids);
    }


    @Override
    @Transactional
    public void changePassword(AuthChangePasswordForm form) {
        repository.changePassword(form.getUsername(), passwordEncoder.encode(form.getPassword()));
    }
}
