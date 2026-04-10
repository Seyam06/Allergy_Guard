package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctor_recommendation_view")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRecommendationView {

    @Id
    private String doctor_name; // temporary primary key

    private String specialization;
    private String hospital_name;
    private String location;
}