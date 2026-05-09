package com.Covix.AllergyGuard.Repository;

import com.Covix.AllergyGuard.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {


    @Query("SELECT m FROM Medicine m WHERE m.targetRisk = :risk OR m.targetSymptom IN :symptoms")
    List<Medicine> findSuggestions(String risk, List<String> symptoms);
}