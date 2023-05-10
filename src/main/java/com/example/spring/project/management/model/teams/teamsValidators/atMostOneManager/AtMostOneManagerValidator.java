package com.example.spring.project.management.model.teams.teamsValidators.atMostOneManager;


import com.example.spring.project.management.model.employees.Employee;
import com.example.spring.project.management.model.employees.Subtype;
import com.example.spring.project.management.model.teams.Team;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AtMostOneManagerValidator implements ConstraintValidator<AtMostOneManager, Team> {

    @Override
    public void initialize(AtMostOneManager constraintAnnotation) {
    }

    @Override
    public boolean isValid(Team team, ConstraintValidatorContext constraintValidatorContext) {
        int managerCount = 0;
        for (Employee employee : team.getEmployees()) {
            if (employee.getSubtype() == Subtype.MANAGER) {
                managerCount++;
                if (managerCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
