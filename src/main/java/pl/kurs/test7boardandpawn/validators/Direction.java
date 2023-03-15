package pl.kurs.test7boardandpawn.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {DirectionValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Direction {

    String message() default "Invalid Direction";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
