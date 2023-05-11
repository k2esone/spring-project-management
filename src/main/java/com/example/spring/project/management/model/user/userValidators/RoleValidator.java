package com.example.spring.project.management.model.user.userValidators;

import com.example.spring.project.management.model.user.models.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<ValidRole, User> {
    @Override
    public void initialize(ValidRole constraintAnnotation) {
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (user.getRoles() == null) {
            return false;
        }
        return user.getRoles().equals("ROLE_USER") || user.getRoles().equals("ROLE_ADMIN");
    }
}
