package com.Covix.AllergyGuard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Covix.AllergyGuard.Entity.PersonAllergyRiskView;

public interface PersonAllergyRiskViewRepository
        extends JpaRepository<PersonAllergyRiskView, String> {
}