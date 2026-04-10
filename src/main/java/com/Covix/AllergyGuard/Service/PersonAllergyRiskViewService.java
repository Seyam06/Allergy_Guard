package com.Covix.AllergyGuard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.Covix.AllergyGuard.Entity.PersonAllergyRiskView;
import com.Covix.AllergyGuard.Repository.PersonAllergyRiskViewRepository;

@Service
public class PersonAllergyRiskViewService {

    @Autowired
    private PersonAllergyRiskViewRepository repo;

    public List<PersonAllergyRiskView> getAllData() {
        return repo.findAll();
    }
}