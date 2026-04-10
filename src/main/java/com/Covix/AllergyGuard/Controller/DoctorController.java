package com.Covix.AllergyGuard.Controller;

import com.Covix.AllergyGuard.Entity.Doctor;
import com.Covix.AllergyGuard.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "doctor";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Doctor d) {
        service.save(d);
        return "redirect:/doctor";
    }
}
