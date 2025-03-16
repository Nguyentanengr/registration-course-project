package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "specialization")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specialization {
    @Id
    @Column(name = "specialization_id", length = 12)
    private String specializationId;

    @Column(name = "specialization_name", nullable = false, length = 255)
    private String specializationName;

    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "specialization")
    private Set<StudyPlan> studyPlans;

    @Override
    public String toString() {
        return "Specialization{" +
                "specializationId='" + specializationId + '\'' +
                ", specializationName='" + specializationName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
