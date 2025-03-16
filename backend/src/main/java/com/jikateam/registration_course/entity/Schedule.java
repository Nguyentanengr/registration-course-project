package com.jikateam.registration_course.entity;

import com.jikateam.registration_course.constant.DayOfWeek;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek; // 0: Monday, ..., 6: Sunday

    @Column(name = "start_period", nullable = false)
    private Integer startPeriod;

    @Column(name = "end_period", nullable = false)
    private Integer endPeriod;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", dayOfWeek=" + dayOfWeek +
                ", startPeriod=" + startPeriod +
                ", endPeriod=" + endPeriod +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}