package com.Covix.AllergyGuard.Controller;

import com.Covix.AllergyGuard.Entity.Allergy;
import com.Covix.AllergyGuard.Service.AllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/allergy")
public class AllergyController {

    @Autowired
    private AllergyService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAll());
        return "allergy";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Allergy a) {
        service.save(a);
        return "redirect:/allergy";
    }
}