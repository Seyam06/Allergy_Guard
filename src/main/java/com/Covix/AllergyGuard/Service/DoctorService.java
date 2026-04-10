package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Entity.Doctor;
import com.Covix.AllergyGuard.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

    public void save(Doctor d) {
        repo.save(d);
    }

    public List<Doctor> getAll() {
        return repo.findAll();
    }
}
