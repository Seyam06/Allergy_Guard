package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medicines")
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int medicineId;

    @Column(name = "medicine_name")
    private String medicineName;

    private String category;
    private String dosage;

    @Column(name = "target_risk")
    private String targetRisk;

    @Column(name = "target_symptom")
    private String targetSymptom;
}