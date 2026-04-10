package com.Covix.AllergyGuard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Covix.AllergyGuard.Entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}