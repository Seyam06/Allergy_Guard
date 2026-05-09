package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person_symptoms")
@Data
public class PersonSymptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ps_id")
    private int psId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;

    private String severity;
}