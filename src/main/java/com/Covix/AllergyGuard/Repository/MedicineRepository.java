package com.Covix.AllergyGuard.Repository;

import com.Covix.AllergyGuard.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
}