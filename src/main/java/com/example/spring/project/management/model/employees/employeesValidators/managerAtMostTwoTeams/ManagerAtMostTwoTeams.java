package com.example.spring.project.management.model.employees.employeesValidators.managerAtMostTwoTeams;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ManagerAtMostTwoTeamValidator.class)
public @interface ManagerAtMostTwoTeams {
    String message() default "Manager must be assigned to at most 2 teams";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};

}
