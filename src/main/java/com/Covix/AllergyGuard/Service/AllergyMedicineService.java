package com.Covix.AllergyGuard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Covix.AllergyGuard.Entity.AllergyMedicine;
import com.Covix.AllergyGuard.Repository.AllergyMedicineRepository;

@Service
public class AllergyMedicineService {

    @Autowired
    private AllergyMedicineRepository repo;

    public void save(AllergyMedicine am) {
        repo.save(am);
    }

    public List<AllergyMedicine> getAll() {
        return repo.findAll();
    }
}