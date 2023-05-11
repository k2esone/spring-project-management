package com.example.spring.project.management.model.projects;

import com.example.spring.project.management.model.teams.Team;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String projectName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Team team;

}
