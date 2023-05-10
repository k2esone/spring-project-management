package com.example.spring.project.management.model.employees;

import com.example.spring.project.management.model.teams.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private LocalDate dateOfEmployment;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Subtype subtype;

    @ManyToMany
    private Set<Team> teams;
}
