package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Entity.Allergy;
import com.Covix.AllergyGuard.Repository.AllergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergyService {

    @Autowired
    private AllergyRepository repo;

    public void save(Allergy a) {
        repo.save(a);
    }

    public List<Allergy> getAll() {
        return repo.findAll();
    }
}