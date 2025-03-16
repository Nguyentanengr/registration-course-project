package com.jikateam.registration_course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnrollmentId implements Serializable {
    @Column(name = "open_session_registration_id")
    private Integer openSessionRegistrationId;

    @Column(name = "student_id", length = 12)
    private String studentId;

    // getters, setters, equals, hashCode
}
