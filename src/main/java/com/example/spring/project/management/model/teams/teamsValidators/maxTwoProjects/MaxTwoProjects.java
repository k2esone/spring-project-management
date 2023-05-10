package com.example.spring.project.management.model.teams.teamsValidators.maxTwoProjects;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaxTwoProjectsValidator.class)
public @interface MaxTwoProjects {
    String message() default "Team can be assigned to max 2 projects";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
