package com.Covix.AllergyGuard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Covix.AllergyGuard.Service.AllergyRiskService;

@Controller
@RequestMapping("/risk")
public class AllergyRiskController {

    @Autowired
    private AllergyRiskService service;

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("list", service.getAll());
        return "risk";
    }

    @GetMapping("/person")
    public String showByPerson(@RequestParam int person_id, Model model) {
        model.addAttribute("list", service.getByPerson(person_id));
        return "risk";
    }
}