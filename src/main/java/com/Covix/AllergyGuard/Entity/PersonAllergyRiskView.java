package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person_allergy_risk_view")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAllergyRiskView {

    @Id
    private String name;   // temporary ID (can be any unique column)

    private float temperature;
    private float humidity;
    private String pollen_level;
    private String risk_level;
}