package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Allergy_Risk")
@Data
public class AllergyRisk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "risk_id")
    private int riskId;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "weather_id")
    private int weatherId;

    @Column(name = "risk_level")
    private String riskLevel;

    @Column(name = "prediction_date")
    private Date predictionDate;
}