package com.Covix.AllergyGuard.Controller;

import com.Covix.AllergyGuard.Entity.Appointment;
import com.Covix.AllergyGuard.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "appointment";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Appointment a) {
        service.save(a);
        return "redirect:/appointment";
    }
}
