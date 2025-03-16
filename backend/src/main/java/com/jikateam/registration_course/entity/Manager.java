package com.jikateam.registration_course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "manager")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    @Column(name = "manager_id", length = 12)
    private String managerId;

    @Column(name = "manager_name", nullable = false, length = 255)
    private String managerName;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true)
    private Account account;

    @Column(length = 255)
    private String email;

    @OneToMany(mappedBy = "manager")
    private Set<RegistrationPhase> registrationPhases;

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}