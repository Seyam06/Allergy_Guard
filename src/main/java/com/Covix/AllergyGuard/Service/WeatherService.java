package com.Covix.AllergyGuard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Covix.AllergyGuard.Entity.Weather;
import com.Covix.AllergyGuard.Repository.WeatherRepository;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository repo;

    public void saveWeather(Weather w) {
        repo.save(w);
        // 🔥 এখানেই trigger fire হবে (AFTER INSERT)
    }
}