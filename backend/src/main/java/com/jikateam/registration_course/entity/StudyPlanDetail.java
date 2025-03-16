package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "study_plan_detail")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyPlanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_plan_detail_id")
    private Integer studyPlanDetailId;

    @ManyToOne
    @JoinColumn(name = "study_plan_id")
    private StudyPlan studyPlan;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(nullable = false)
    private Integer semester;

    @OneToOne(mappedBy = "studyPlanDetail")
    private PeriodDetail periodDetail;

    @Override
    public String toString() {
        return "StudyPlanDetail{" +
                "studyPlanDetailId=" + studyPlanDetailId +
                ", studyPlan=" + studyPlan +
                ", course=" + course +
                ", semester=" + semester +
                ", periodDetail=" + periodDetail +
                '}';
    }
}