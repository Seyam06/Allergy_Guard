package com.Covix.AllergyGuard.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int weather_id;

    private Double temperature;
    private Double humidity;

    @Column(name = "pollen_level")
    private String pollen_level;


    @Column(name = "air_quality")
    private Integer airQuality;


    @Column(name = "record_date")
    private LocalDateTime recordDate;

    @PrePersist
    protected void onCreate() {
        recordDate = LocalDateTime.now();
    }
}