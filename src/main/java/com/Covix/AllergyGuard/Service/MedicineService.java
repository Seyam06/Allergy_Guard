package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Entity.Medicine;
import com.Covix.AllergyGuard.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository repo;

    public void save(Medicine m) {
        repo.save(m);
    }

    public List<Medicine> getAll() {
        return repo.findAll();
    }
}