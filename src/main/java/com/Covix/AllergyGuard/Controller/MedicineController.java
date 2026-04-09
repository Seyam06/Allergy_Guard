package com.Covix.AllergyGuard.Controller;

import com.Covix.AllergyGuard.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicine")
public class MedicineController<Medicine> {

    @Autowired
    private MedicineService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "medicine";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Medicine m) {
        service.save((com.Covix.AllergyGuard.Entity.Medicine) m);
        return "redirect:/medicine";
    }
}