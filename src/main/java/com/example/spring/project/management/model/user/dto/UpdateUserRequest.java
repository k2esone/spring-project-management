package com.example.spring.project.management.model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    private String passwordR;
    private String emailR;
    private boolean activeR;
    private String rolesR;
}
