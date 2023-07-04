package spring.BshopServer.validation;


import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import spring.BshopServer.repository.IProductRepository;

public class ProductNotExistsByNameValidator implements ConstraintValidator<ProductNotExistsByName, String> {
    @Autowired
    private IProductRepository repository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(name);
    }
}
