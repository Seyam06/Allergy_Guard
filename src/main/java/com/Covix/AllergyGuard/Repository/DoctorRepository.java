package com.Covix.AllergyGuard.Repository;

import com.Covix.AllergyGuard.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
