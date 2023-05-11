package com.example.spring.project.management.model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserResponse {

    private Long idR;

    private String userNameR;
    private String passwordR;
    private String emailR;
    private boolean activeR;
    private String rolesR;
}
