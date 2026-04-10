package com.Covix.AllergyGuard.Repository;

import com.Covix.AllergyGuard.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}