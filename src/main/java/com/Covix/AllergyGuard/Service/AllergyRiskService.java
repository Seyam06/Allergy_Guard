package com.Covix.AllergyGuard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.Covix.AllergyGuard.Entity.AllergyRisk;
import com.Covix.AllergyGuard.Repository.AllergyRiskRepository;

@Service
public class AllergyRiskService {

    @Autowired
    private AllergyRiskRepository repo;

    public List<AllergyRisk> getAll() {
        return repo.findAll();
    }

    public List<AllergyRisk> getByPerson(int person_id) {
        return repo.findByPersonId(person_id);
    }
}