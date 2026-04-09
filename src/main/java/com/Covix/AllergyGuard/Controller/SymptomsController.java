package com.Covix.AllergyGuard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Covix.AllergyGuard.Entity.Symptoms;
import com.Covix.AllergyGuard.Service.SymptomsService;

@Controller
@RequestMapping("/symptoms")
public class SymptomsController {

    @Autowired
    private SymptomsService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "symptoms";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Symptoms s) {
        service.save(s);
        return "redirect:/symptoms";
    }
}