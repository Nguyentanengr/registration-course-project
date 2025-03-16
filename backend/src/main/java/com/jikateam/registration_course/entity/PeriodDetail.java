package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "period_detail")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeriodDetail {
    @Id
    @OneToOne
    @JoinColumn(name = "study_plan_detail_id")
    private StudyPlanDetail studyPlanDetail;

    @Column(name = "total_periods", nullable = false)
    private Integer totalPeriods = 0;

    @Column(name = "lecture_periods", nullable = false)
    private Integer lecturePeriods = 0;

    @Column(name = "assignment_periods", nullable = false)
    private Integer assignmentPeriods = 0;

    @Column(name = "practical_periods", nullable = false)
    private Integer practicalPeriods = 0;

    @Column(name = "self_study_periods", nullable = false)
    private Integer selfStudyPeriods = 0;

    @Override
    public String toString() {
        return "PeriodDetail{" +
                "studyPlanDetail=" + studyPlanDetail +
                ", totalPeriods=" + totalPeriods +
                ", lecturePeriods=" + lecturePeriods +
                ", assignmentPeriods=" + assignmentPeriods +
                ", practicalPeriods=" + practicalPeriods +
                ", selfStudyPeriods=" + selfStudyPeriods +
                '}';
    }
}
