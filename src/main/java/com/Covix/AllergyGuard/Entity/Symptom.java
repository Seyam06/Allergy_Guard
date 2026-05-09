package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "symptoms")
@Data
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int symptomId;

    private String symptomName;
}