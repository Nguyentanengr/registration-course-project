package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "support_requirement")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "support_requirement_id")
    private Integer supportRequirementId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String reason;

    @Override
    public String toString() {
        return "SupportRequirement{" +
                "supportRequirementId=" + supportRequirementId +
                ", student=" + student +
                ", title='" + title + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
