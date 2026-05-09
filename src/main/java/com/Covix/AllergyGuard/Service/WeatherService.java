package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Entity.Weather;
import com.Covix.AllergyGuard.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public Weather getLatestWeather() {
        return weatherRepository.findFirstByOrderByRecordDateDesc()
                .orElse(null);
    }
}