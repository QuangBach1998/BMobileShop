package spring.BshopServer.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import spring.BshopServer.repository.IAccountRepository;



public class AccountExistsByIdValidator implements ConstraintValidator<AccountExistsById, Integer> {
    @Autowired
    private IAccountRepository repository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsById(id);
    }
}
