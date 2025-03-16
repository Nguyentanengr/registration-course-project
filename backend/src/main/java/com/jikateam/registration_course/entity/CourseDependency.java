package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course_dependency")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDependency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_dependency_id")
    private Integer courseDependencyId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "required_course")
    private Course requiredCourse;

    @Column(name = "type_dependency", nullable = false, length = 50)
    private String typeDependency;


    @Override
    public String toString() {
        return "CourseDependency{" +
                "courseDependencyId=" + courseDependencyId +
                ", course=" + course +
                ", requiredCourse=" + requiredCourse +
                ", typeDependency='" + typeDependency + '\'' +
                '}';
    }
}
