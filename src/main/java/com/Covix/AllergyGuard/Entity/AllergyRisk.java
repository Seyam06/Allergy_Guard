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

    private int person_id;
    private int allergy_id;
    private String risk_level;
}