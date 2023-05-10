package com.example.spring.project.management.model.teams.teamsValidators.atMostTenDevelopers;

import com.example.spring.project.management.model.employees.Employee;
import com.example.spring.project.management.model.employees.Subtype;
import com.example.spring.project.management.model.teams.Team;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AtMostTenDevelopersValidator implements ConstraintValidator<AtMostTenDevelopers, Team> {
    @Override
    public void initialize(AtMostTenDevelopers constraintAnnotation) {
    }

    @Override
    public boolean isValid(Team team, ConstraintValidatorContext constraintValidatorContext) {
        int developersCount = 0;
        for (Employee employee : team.getEmployees()) {
            if (employee.getSubtype() == Subtype.DEVELOPER) {
                developersCount++;
                if (developersCount > 10) {
                    return false;
                }
            }
        }
        return true;
    }
}
