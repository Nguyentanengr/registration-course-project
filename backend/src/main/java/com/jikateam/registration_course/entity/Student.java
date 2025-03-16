package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "student_id", length = 12)
    private String studentId;

    @Column(nullable = false, length = 255)
    private String fullname;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 10)
    private String phone;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true)
    private Account account;

    @OneToMany(mappedBy = "student")
    private Set<ClassEnrollment> classEnrollments;

    @OneToMany(mappedBy = "student")
    private Set<SupportRequirement> supportRequirements;

    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments;

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", isActive=" + isActive +
                ", account=" + account +
                '}';
    }
}