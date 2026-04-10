package com.Covix.AllergyGuard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Covix.AllergyGuard.Entity.DoctorRecommendationView;

public interface DoctorRecommendationRepository extends JpaRepository<DoctorRecommendationView, String> {
}