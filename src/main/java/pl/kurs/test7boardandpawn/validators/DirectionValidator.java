package pl.kurs.test7boardandpawn.validators;

import pl.kurs.test7boardandpawn.model.Direction;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DirectionValidator implements ConstraintValidator<pl.kurs.test7boardandpawn.validators.Direction, String> {
    @Override
    public void initialize(pl.kurs.test7boardandpawn.validators.Direction constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Direction.valueOf(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
