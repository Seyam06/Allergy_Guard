package com.Covix.AllergyGuard.Repository;

import com.Covix.AllergyGuard.Entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SymptomRepository extends JpaRepository<Symptom, Integer> {
    Optional<Symptom> findBySymptomName(String name);
}