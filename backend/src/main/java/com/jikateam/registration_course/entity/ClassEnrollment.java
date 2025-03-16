package com.jikateam.registration_course.entity;

import com.jikateam.registration_course.constant.ClassEnrollmentStatus;
import jakarta.persistence.*;
import lombok.*;

// ClassEnrollment.java
@Entity
@Table(name = "class_enrollment")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_enrollment_id")
    private Integer classEnrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classEntity;

    @Column(nullable = false)
    private ClassEnrollmentStatus status; // 0: enrolled, 1: completed, 2: drop out

    @Override
    public String toString() {
        return "ClassEnrollment{" +
                "classEnrollmentId=" + classEnrollmentId +
                ", student=" + student +
                ", status=" + status +
                '}';
    }
}
