package com.Covix.AllergyGuard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Covix.AllergyGuard.Entity.PersonSymptoms;
import com.Covix.AllergyGuard.Repository.PersonSymptomsRepository;

@Service
public class PersonSymptomsService {

    @Autowired
    private PersonSymptomsRepository repo;

    public void save(PersonSymptoms ps) {
        repo.save(ps);
    }

    public List<PersonSymptoms> getAll() {
        return repo.findAll();
    }
}