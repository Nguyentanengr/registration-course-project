package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "study_plan")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_plan_id")
    private Integer studyPlanId;

    @Column(name = "is_disable", nullable = false)
    private Boolean isDisable = false;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "education_program_id")
    private EducationProgram educationProgram;

    @OneToMany(mappedBy = "studyPlan")
    private Set<StudyPlanDetail> studyPlanDetails;

    @Override
    public String toString() {
        return "StudyPlan{" +
                "studyPlanId=" + studyPlanId +
                ", isDisable=" + isDisable +
                ", specialization=" + specialization +
                '}';
    }
}
