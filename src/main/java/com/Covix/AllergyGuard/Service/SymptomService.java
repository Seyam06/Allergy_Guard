package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Entity.PersonSymptom;
import com.Covix.AllergyGuard.Entity.Symptom;
import com.Covix.AllergyGuard.Repository.PersonSymptomRepository;
import com.Covix.AllergyGuard.Repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private PersonSymptomRepository personSymptomRepository;

    public void linkSymptomToUser(Person user, List<String> symptomNames) {
        for (String name : symptomNames) {
            Symptom symptom = symptomRepository.findBySymptomName(name)
                    .orElseThrow(() -> new RuntimeException("Symptom not found: " + name));

            PersonSymptom ps = new PersonSymptom();
            ps.setPerson(user);
            ps.setSymptom(symptom);
            ps.setSeverity("Normal");

            personSymptomRepository.save(ps);
        }
    }
}