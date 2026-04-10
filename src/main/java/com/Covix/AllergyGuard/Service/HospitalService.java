package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Entity.Hospital;
import com.Covix.AllergyGuard.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository repo;

    public void save(Hospital h) {
        repo.save(h);
    }

    public List<Hospital> getAll() {
        return repo.findAll();
    }
}