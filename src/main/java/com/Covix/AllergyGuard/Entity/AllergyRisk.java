package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "allergy_risk")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergyRisk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int risk_id;

    @Column(name = "person_id")   // DB column
    private int personId;         // Java field (camelCase)

    @Column(name = "allergy_id")
    private int allergyId;

    private String risk_level;
}