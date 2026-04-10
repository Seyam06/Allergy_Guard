package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "allergy_medicine")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergyMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int am_id;

    private int allergy_id;
    private int medicine_id;
}