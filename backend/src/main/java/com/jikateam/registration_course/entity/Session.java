package com.jikateam.registration_course.entity;

import com.jikateam.registration_course.constant.SessionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "session")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Integer sessionId;

    @Column(name = "group_number", nullable = false)
    private Integer groupNumber;

    @Column(nullable = false)
    private Integer semester;

    @Column(nullable = false)
    private Integer year;

    @Column(name = "max_students", nullable = false)
    private Integer maxStudents = 100;

    @Column(name = "min_students", nullable = false)
    private Integer minStudents = 0;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classEntity;

    @Column(nullable = false)
    private SessionStatus status; // 0: pending, 1: teaching, 2: completed

    @OneToMany(mappedBy = "session")
    private Set<Schedule> schedules;

    @OneToMany(mappedBy = "session")
    private Set<OpenSessionRegistration> openSessionRegistrations;

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", groupNumber=" + groupNumber +
                ", semester=" + semester +
                ", year=" + year +
                ", maxStudents=" + maxStudents +
                ", minStudents=" + minStudents +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}