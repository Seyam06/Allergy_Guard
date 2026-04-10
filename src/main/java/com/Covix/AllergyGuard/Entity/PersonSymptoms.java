package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person_symptoms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSymptoms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ps_id;

    private int person_id;
    private int symptom_id;
    private String severity;
}