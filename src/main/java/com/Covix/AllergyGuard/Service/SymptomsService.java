package com.Covix.AllergyGuard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Covix.AllergyGuard.Entity.Symptoms;
import com.Covix.AllergyGuard.Repository.SymptomsRepository;

@Service
public class SymptomsService {

    @Autowired
    private SymptomsRepository repo;

    public void save(Symptoms s) {
        repo.save(s);
    }

    public List<Symptoms> getAll() {
        return repo.findAll();
    }
}