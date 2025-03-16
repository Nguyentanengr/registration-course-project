package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "major")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Major {
    @Id
    @Column(name = "major_id", length = 12)
    private String majorId;

    @Column(name = "major_name", nullable = false, length = 255)
    private String majorName;

    @Column(length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "major")
    private Set<EducationProgram> educationPrograms;

    @Override
    public String toString() {
        return "Major{" +
                "majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
