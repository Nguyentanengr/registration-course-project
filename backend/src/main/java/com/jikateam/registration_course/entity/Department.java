package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "department")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @Column(name = "department_id", length = 12)
    private String departmentId;

    @Column(name = "department_name", nullable = false, length = 255)
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private Set<Major> majors;

    @OneToMany(mappedBy = "department")
    private Set<Teacher> teachers;

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
