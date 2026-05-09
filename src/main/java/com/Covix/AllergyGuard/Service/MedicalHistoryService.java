package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Dto.MedicalHistoryDTO;
import com.Covix.AllergyGuard.Entity.AllergyRisk;
import com.Covix.AllergyGuard.Entity.Medicine;
import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Entity.PersonSymptom;
import com.Covix.AllergyGuard.Repository.AllergyRiskRepository;
import com.Covix.AllergyGuard.Repository.MedicineRepository;
import com.Covix.AllergyGuard.Repository.PersonSymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MedicalHistoryService {

    @Autowired
    private PersonSymptomRepository psRepo;
    @Autowired
    private AllergyRiskRepository riskRepo;

    @Autowired
    private MedicineRepository medicineRepository;

    public List<MedicalHistoryDTO> getTimeline(Person user) {

        List<PersonSymptom> symptomsRecords = psRepo.findByPersonOrderByPsIdDesc(user);

        Map<String, List<String>> groupedSymptoms = new LinkedHashMap<>();

        for (PersonSymptom ps : symptomsRecords) {

            String date = "2026-04-11";
            groupedSymptoms.computeIfAbsent(date, k -> new ArrayList<>()).add(ps.getSymptom().getSymptomName());
        }

        List<MedicalHistoryDTO> timeline = new ArrayList<>();

        groupedSymptoms.forEach((date, symptomsList) -> {

            String risk = riskRepo.findFirstByPersonIdOrderByRiskIdDesc(user.getPerson_id())
                    .map(AllergyRisk::getRiskLevel).orElse("LOW");

            List<Medicine> meds = medicineRepository.findSuggestions(risk, symptomsList);


            String suggestionText = meds.isEmpty() ? "General Care" :
                    meds.stream().map(Medicine::getMedicineName).collect(Collectors.joining(", "));


            timeline.add(new MedicalHistoryDTO(date, symptomsList, risk, "30°C, High Pollen", suggestionText));
        });

        return timeline;
    }
}