package com.jikateam.registration_course.entity;

import com.jikateam.registration_course.constant.RegistrationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "open_session_registration")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenSessionRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "open_session_registration_id")
    private Integer openSessionRegistrationId;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private RegistrationStatus status; // 0: pending, 1: open, 2: close, 3: cancel, 4: conform

    @ManyToOne
    @JoinColumn(name = "registration_phase_id")
    private RegistrationPhase registrationPhase;

    @OneToMany(mappedBy = "openSessionRegistration")
    private Set<Enrollment> enrollments;

    @Override
    public String toString() {
        return "OpenSessionRegistration{" +
                "openSessionRegistrationId=" + openSessionRegistrationId +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }
}
