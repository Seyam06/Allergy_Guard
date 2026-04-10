package com.Covix.AllergyGuard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Covix.AllergyGuard.Entity.AllergyMedicine;
import com.Covix.AllergyGuard.Service.AllergyMedicineService;

@Controller
@RequestMapping("/allergy-medicine")
public class AllergyMedicineController {

    @Autowired
    private AllergyMedicineService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "allergy_medicine";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute AllergyMedicine am) {
        service.save(am);
        return "redirect:/allergy-medicine";
    }
}