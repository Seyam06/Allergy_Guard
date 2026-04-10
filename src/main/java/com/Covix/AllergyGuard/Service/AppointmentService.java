package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Entity.Appointment;
import com.Covix.AllergyGuard.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    public void save(Appointment a) {
        repo.save(a);
    }

    public List<Appointment> getAll() {
        return repo.findAll();
    }
}
