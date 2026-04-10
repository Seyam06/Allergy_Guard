package com.Covix.AllergyGuard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Covix.AllergyGuard.Entity.PersonSymptoms;
import com.Covix.AllergyGuard.Service.PersonSymptomsService;

@Controller
@RequestMapping("/person-symptoms")
public class PersonSymptomsController {

    @Autowired
    private PersonSymptomsService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "person_symptoms";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute PersonSymptoms ps) {
        service.save(ps);
        return "redirect:/person-symptoms";
    }
}