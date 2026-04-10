package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "allergy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allergy {

    @Id   // ✅ MUST ADD THIS
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int allergy_id;

    private String allergy_name;
    private String description;
    private String severity_level;
}