package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "type_training")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_training_id")
    private Integer typeTrainingId;

    @Column(name = "type_training_name", nullable = false, length = 255)
    private String typeTrainingName;

    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "typeTraining")
    private Set<EducationProgram> educationPrograms;

    @Override
    public String toString() {
        return "TypeTraining{" +
                "typeTrainingId=" + typeTrainingId +
                ", typeTrainingName='" + typeTrainingName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}