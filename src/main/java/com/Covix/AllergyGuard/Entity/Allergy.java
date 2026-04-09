package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "allergy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allergy {

    @jakarta.persistence.Id
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int allergy_id;

    private String allergy_name;
    private String description;
    private String severity_level;
}