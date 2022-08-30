package hu.regina.validation;

import hu.regina.domain.Home;
import hu.regina.service.HomeService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueHomeIDValidator implements ConstraintValidator<UniqueHomeID, Integer> {

    HomeService homeService;

    public UniqueHomeIDValidator(HomeService homeService) {
        this.homeService = homeService;
    }

    @Override
    public void initialize(UniqueHomeID constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Hey I've ran!");
        Home home = homeService.findHomeById(value);
        return home == null;
    }
}
