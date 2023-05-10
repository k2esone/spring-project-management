package com.example.spring.project.management.model.teams.teamsValidators.atMostOneManager;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtMostOneManagerValidator.class)
public @interface AtMostOneManager {
    String message() default "Team must have at most 1 manager";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
