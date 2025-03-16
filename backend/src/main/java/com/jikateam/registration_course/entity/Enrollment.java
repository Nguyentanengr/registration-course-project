package com.jikateam.registration_course.entity;

import com.jikateam.registration_course.constant.EnrollmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollment")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @MapsId("openSessionRegistrationId")
    @JoinColumn(name = "openSessionRegistration_id")
    private OpenSessionRegistration openSessionRegistration;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "enroll_time", nullable = false)
    private LocalDateTime enrollTime;

    @Column
    private EnrollmentStatus status; // 0: enrolled, 1: cancelled

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", enrollTime=" + enrollTime +
                ", status=" + status +
                '}';
    }
}
