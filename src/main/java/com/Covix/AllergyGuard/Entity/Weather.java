package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "weather")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int weather_id;

    private float temperature;
    private float humidity;
    private String pollen_level;
    private String air_quality;

    private java.sql.Date record_date;
}