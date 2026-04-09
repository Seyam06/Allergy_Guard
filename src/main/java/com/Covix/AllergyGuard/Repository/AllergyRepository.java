package com.Covix.AllergyGuard.Repository;

import com.Covix.AllergyGuard.Entity.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepository extends JpaRepository<Allergy, Integer> {
}