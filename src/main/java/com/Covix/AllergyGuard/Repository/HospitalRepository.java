package com.Covix.AllergyGuard.Repository;

import com.Covix.AllergyGuard.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}