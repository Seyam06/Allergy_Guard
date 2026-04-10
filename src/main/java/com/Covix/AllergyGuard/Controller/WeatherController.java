package com.Covix.AllergyGuard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.Covix.AllergyGuard.Entity.Weather;
import com.Covix.AllergyGuard.Service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("weather", new Weather());
        return "weather_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Weather w) {
        service.saveWeather(w);
        return "redirect:/risk"; // after insert show risk
    }
}