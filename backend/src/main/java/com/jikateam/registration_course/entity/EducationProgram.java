package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "education_program")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_program_id")
    private Integer educationProgramId;

    @Column(name = "education_program_name", nullable = false, length = 255)
    private String educationProgramName;

    @Column(name = "total_credits", nullable = false)
    private Integer totalCredits;

    @Column(name = "number_of_semester", nullable = false)
    private Integer numberOfSemester;

    @Column(name = "apply_year", nullable = false)
    private Integer applyYear;

    @Column(name = "expiration_year", nullable = false)
    private Integer expirationYear;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToOne
    @JoinColumn(name = "type_training_id")
    private TypeTraining typeTraining;

    @OneToMany(mappedBy = "educationProgram")
    private Set<Class> classes;

    @OneToMany(mappedBy = "educationProgram")
    private Set<StudyPlan> studyPlans;

    @Override
    public String toString() {
        return "EducationProgram{" +
                "educationProgramId=" + educationProgramId +
                ", educationProgramName='" + educationProgramName + '\'' +
                ", totalCredits=" + totalCredits +
                ", numberOfSemester=" + numberOfSemester +
                ", applyYear=" + applyYear +
                ", expirationYear=" + expirationYear +
                '}';
    }
}
