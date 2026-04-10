package com.Covix.AllergyGuard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Covix.AllergyGuard.Service.DoctorRecommendationService;

@Controller
@RequestMapping("/doctor-view")
public class DoctorRecommendationController {

    @Autowired
    private DoctorRecommendationService service;

    @GetMapping
    public String view(Model model) {
        model.addAttribute("list", service.getAll());
        return "doctor_view";
    }
}