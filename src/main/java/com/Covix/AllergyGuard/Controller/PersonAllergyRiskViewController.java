package com.Covix.AllergyGuard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Covix.AllergyGuard.Service.PersonAllergyRiskViewService;

@Controller
@RequestMapping("/person-risk-view")
public class PersonAllergyRiskViewController {

    @Autowired
    private PersonAllergyRiskViewService service;

    @GetMapping
    public String showView(Model model) {
        model.addAttribute("list", service.getAllData());
        return "person_allergy_risk_view";
    }
}