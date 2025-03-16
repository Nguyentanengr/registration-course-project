package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "class")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @Column(name = "class_id", length = 12)
    private String classId;

    @Column(name = "number_of_students", nullable = false)
    private Integer numberOfStudents;

    @Column(name = "start_year", nullable = false)
    private Integer startYear;

    @Column(name = "end_year", nullable = false)
    private Integer endYear;

    @ManyToOne
    @JoinColumn(name = "education_program_id")
    private EducationProgram educationProgram;

    @OneToMany(mappedBy = "classEntity")
    private Set<ClassEnrollment> classEnrollments;

    @OneToMany(mappedBy = "classEntity")
    private Set<Session> sessions;

    @Override
    public String toString() {
        return "Class{" +
                "classId='" + classId + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}
