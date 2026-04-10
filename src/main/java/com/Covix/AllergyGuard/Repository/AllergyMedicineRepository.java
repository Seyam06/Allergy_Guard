package com.Covix.AllergyGuard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Covix.AllergyGuard.Entity.AllergyMedicine;

public interface AllergyMedicineRepository extends JpaRepository<AllergyMedicine, Integer> {
}