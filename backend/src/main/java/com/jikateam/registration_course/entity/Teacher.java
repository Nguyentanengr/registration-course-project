package com.jikateam.registration_course.entity;

import com.jikateam.registration_course.constant.TeacherStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @Column(name = "teacher_id", length = 12)
    private String teacherId;

    @Column(nullable = false, length = 255)
    private String fullname;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private TeacherStatus status; // 0: active, 1: on_leave, 2: resigned

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    @OneToMany(mappedBy = "teacher")
    private Set<Schedule> schedules;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", status=" + status +
                ", isActive=" + isActive +
                '}';
    }
}
