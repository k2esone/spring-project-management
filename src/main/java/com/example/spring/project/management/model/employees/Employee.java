package com.example.spring.project.management.model.employees;

import com.example.spring.project.management.model.employees.employeesValidators.devAtMostOneTeam.DevAtMostOneTeam;
import com.example.spring.project.management.model.employees.employeesValidators.managerAtMostTwoTeams.ManagerAtMostTwoTeams;
import com.example.spring.project.management.model.teams.Team;
import lombok.*;
import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DevAtMostOneTeam
@ManagerAtMostTwoTeams
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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
    private Set<Team> teams;
}
