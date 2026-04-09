package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "symptoms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Symptoms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int symptom_id;

    private String symptom_name;
}