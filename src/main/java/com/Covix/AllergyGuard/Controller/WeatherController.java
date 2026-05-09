package com.Covix.AllergyGuard.Controller;

import com.Covix.AllergyGuard.Entity.Weather;
import com.Covix.AllergyGuard.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current")
    public Weather getCurrentWeather() {
        return weatherService.getLatestWeather();
    }
}