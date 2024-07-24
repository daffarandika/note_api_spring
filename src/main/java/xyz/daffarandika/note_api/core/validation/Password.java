package xyz.daffarandika.note_api.core.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

    String message() default "password must be at least 8 characters and contain a letter and a number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
