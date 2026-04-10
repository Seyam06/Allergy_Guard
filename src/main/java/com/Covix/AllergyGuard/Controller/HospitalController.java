package com.Covix.AllergyGuard.Controller;

import com.Covix.AllergyGuard.Entity.Hospital;
import com.Covix.AllergyGuard.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "hospital";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Hospital h) {
        service.save(h);
        return "redirect:/hospital";
    }
}