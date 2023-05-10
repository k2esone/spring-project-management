package com.example.spring.project.management.model.teams.teamsValidators.maxTwoProjects;

import com.example.spring.project.management.model.teams.Team;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MaxTwoProjectsValidator implements ConstraintValidator<MaxTwoProjects, Team> {
    @Override
    public void initialize(MaxTwoProjects constraintAnnotation) {
    }

    @Override
    public boolean isValid(Team team, ConstraintValidatorContext constraintValidatorContext) {
        if (team.getProjects().size() > 2) {
            return false;
        }
        return true;
    }
}
