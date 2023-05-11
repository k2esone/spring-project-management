package com.example.spring.project.management.model.user.userValidators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RoleValidator.class)
public @interface ValidRole {
    String message() default "Invalid role, type ROLE_USER or ROLE_ADMIN";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
