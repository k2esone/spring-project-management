package com.example.spring.project.management.model.teams.teamsValidators.atMostTenDevelopers;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtMostTenDevelopersValidator.class)
public @interface AtMostTenDevelopers {
    String message() default "Team must have at most 10 developers";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
