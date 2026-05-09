package com.Covix.AllergyGuard.Repository;

import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Entity.PersonSymptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonSymptomRepository extends JpaRepository<PersonSymptom, Integer> {
    List<PersonSymptom> findByPerson(Person person);
    List<PersonSymptom> findByPersonOrderByPsIdDesc(Person person);
}