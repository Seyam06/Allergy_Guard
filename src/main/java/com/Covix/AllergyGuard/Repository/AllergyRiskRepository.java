package com.Covix.AllergyGuard.Repository;

import com.Covix.AllergyGuard.Entity.AllergyRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllergyRiskRepository extends JpaRepository<AllergyRisk, Integer> {


    Optional<AllergyRisk> findFirstByPersonIdOrderByRiskIdDesc(int personId);
}