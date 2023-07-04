package spring.BshopServer.validation;


import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import spring.BshopServer.repository.ICategoryRepository;

public class CategoryNotExistsByNameValidator implements ConstraintValidator<CategoryNotExistsByName, String> {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(name);
    }
}
