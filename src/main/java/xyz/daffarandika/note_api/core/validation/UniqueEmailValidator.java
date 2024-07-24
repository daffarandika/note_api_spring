package xyz.daffarandika.note_api.core.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.daffarandika.note_api.feature_auth.repository.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepository;

//    public UniqueEmailValidator(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("<=> EXIS GA" + !userRepository.existsByEmail(value));
        return !userRepository.existsByEmail(value);
    }
}
