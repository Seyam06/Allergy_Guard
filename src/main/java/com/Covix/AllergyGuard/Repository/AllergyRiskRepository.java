package com.Covix.AllergyGuard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Covix.AllergyGuard.Entity.AllergyRisk;
import java.util.List;

public interface AllergyRiskRepository extends JpaRepository<AllergyRisk, Integer> {

    List<AllergyRisk> findByPersonId(int person_id);
}