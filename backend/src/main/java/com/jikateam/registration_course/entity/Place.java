package com.jikateam.registration_course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "place")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    @Id
    @Column(name = "place_id", length = 12)
    private String placeId;

    @Column(name = "place_name", nullable = false, length = 255)
    private String placeName;

    @Column(name = "place_capacity")
    private Integer placeCapacity = 0;

    @Override
    public String toString() {
        return "Place{" +
                "placeId='" + placeId + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeCapacity=" + placeCapacity +
                '}';
    }
}
