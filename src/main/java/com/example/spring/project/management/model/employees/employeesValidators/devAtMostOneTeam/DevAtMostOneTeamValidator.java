package com.example.spring.project.management.model.employees.employeesValidators.devAtMostOneTeam;

import com.example.spring.project.management.model.employees.Employee;
import com.example.spring.project.management.model.employees.Subtype;
import com.example.spring.project.management.model.teams.Team;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DevAtMostOneTeamValidator implements ConstraintValidator<DevAtMostOneTeam, Employee> {
    @Override
    public void initialize(DevAtMostOneTeam constraintAnnotation) {
    }

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext constraintValidatorContext) {
        if (employee.getSubtype() == Subtype.DEVELOPER) {
            int teamCount = 0;
            for (Team team : employee.getTeams()) {
                teamCount++;
                if (teamCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
