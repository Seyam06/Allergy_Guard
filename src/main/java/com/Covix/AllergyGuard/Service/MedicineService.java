package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Entity.AllergyRisk;
import com.Covix.AllergyGuard.Entity.Medicine;
import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Repository.AllergyRiskRepository;
import com.Covix.AllergyGuard.Repository.MedicineRepository;
import com.Covix.AllergyGuard.Repository.PersonSymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepo;
    @Autowired
    private AllergyRiskRepository riskRepo;
    @Autowired
    private PersonSymptomRepository psRepo;

    public List<Medicine> getSuggestionsForUser(Person user) {

        String currentRisk = riskRepo.findFirstByPersonIdOrderByRiskIdDesc(user.getPerson_id())
                .map(AllergyRisk::getRiskLevel)
                .orElse("LOW");

        List<String> userSymptoms = psRepo.findByPerson(user).stream()
                .map(ps -> ps.getSymptom().getSymptomName())
                .collect(Collectors.toList());

        return medicineRepo.findSuggestions(currentRisk, userSymptoms);
    }
}