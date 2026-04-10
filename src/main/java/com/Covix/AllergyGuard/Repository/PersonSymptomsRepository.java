package com.Covix.AllergyGuard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Covix.AllergyGuard.Entity.PersonSymptoms;

public interface PersonSymptomsRepository extends JpaRepository<PersonSymptoms, Integer> {
}