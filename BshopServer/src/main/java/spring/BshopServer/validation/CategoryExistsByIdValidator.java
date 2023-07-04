package spring.BshopServer.validation;


import org.springframework.beans.factory.annotation.Autowired;
import spring.BshopServer.repository.ICategoryRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryExistsByIdValidator implements ConstraintValidator<CategoryExistsById, Integer> {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsById(id);
    }
}
