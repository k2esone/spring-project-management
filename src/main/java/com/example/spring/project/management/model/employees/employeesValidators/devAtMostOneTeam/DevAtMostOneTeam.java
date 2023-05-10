package com.example.spring.project.management.model.employees.employeesValidators.devAtMostOneTeam;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DevAtMostOneTeamValidator.class)
public @interface DevAtMostOneTeam {
    String message() default "Developer must be assigned to at most 1 team";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};

}
