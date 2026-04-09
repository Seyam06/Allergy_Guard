package com.Covix.AllergyGuard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Covix.AllergyGuard.Entity.Symptoms;

public interface SymptomsRepository extends JpaRepository<Symptoms, Integer> {
}