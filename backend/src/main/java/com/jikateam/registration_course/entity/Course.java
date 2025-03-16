package com.jikateam.registration_course.entity;

import com.jikateam.registration_course.constant.CourseType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @Column(name = "course_id", length = 12)
    private String courseId;

    @Column(name = "course_name", nullable = false, length = 255)
    private String courseName;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private Integer credits;

    @Column(nullable = false)
    private CourseType type; // 0: general, 1: fundamental, 2: major, 3: internship

    @OneToMany(mappedBy = "course")
    private Set<StudyPlanDetail> studyPlanDetails;

    @ManyToMany(mappedBy = "courses")
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "course")
    private Set<Session> sessions;

    @OneToMany(mappedBy = "course")
    private Set<CourseDependency> courseDependencies;

    @OneToMany(mappedBy = "requiredCourse")
    private Set<CourseDependency> requiredCourseDependencies;

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                ", credits=" + credits +
                ", type=" + type +
                '}';
    }
}
