package com.school.project.domain.student;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@jakarta.persistence.Entity
@Getter @Setter
public class Student {
    @Id
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    @Column(unique = true)
    private String email;
}
