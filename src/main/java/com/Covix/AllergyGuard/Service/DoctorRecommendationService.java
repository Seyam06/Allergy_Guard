package com.Covix.AllergyGuard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.Covix.AllergyGuard.Entity.DoctorRecommendationView;
import com.Covix.AllergyGuard.Repository.DoctorRecommendationRepository;

@Service
public class DoctorRecommendationService {

    @Autowired
    private DoctorRecommendationRepository repo;

    public List<DoctorRecommendationView> getAll() {
        return repo.findAll();
    }
}