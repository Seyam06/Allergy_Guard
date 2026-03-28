package com.Covix.AllergyGuard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Covix.AllergyGuard.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByEmail(String email);
}