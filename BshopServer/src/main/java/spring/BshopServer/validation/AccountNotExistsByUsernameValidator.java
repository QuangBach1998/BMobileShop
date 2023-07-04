package spring.BshopServer.validation;


import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import spring.BshopServer.repository.IAccountRepository;

public class AccountNotExistsByUsernameValidator implements ConstraintValidator<AccountNotExistsByUsername, String> {
    @Autowired
    private IAccountRepository repository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByUsername(username);
    }
}
