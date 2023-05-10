package com.example.spring.project.management.model.employees.employeesValidators.managerAtMostTwoTeams;

import com.example.spring.project.management.model.employees.Employee;
import com.example.spring.project.management.model.employees.Subtype;
import com.example.spring.project.management.model.teams.Team;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ManagerAtMostTwoTeamValidator implements ConstraintValidator<ManagerAtMostTwoTeams, Employee> {
    @Override
    public void initialize(ManagerAtMostTwoTeams constraintAnnotation) {
    }

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext constraintValidatorContext) {
        if (employee.getSubtype() == Subtype.MANAGER) {
            int teamCount = 0;
            for (Team team : employee.getTeams()) {
                teamCount++;
                if (teamCount > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
