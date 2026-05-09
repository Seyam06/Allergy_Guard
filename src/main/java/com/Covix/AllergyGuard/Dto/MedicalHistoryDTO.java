package com.Covix.AllergyGuard.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MedicalHistoryDTO {
    private String date;
    private List<String> symptoms;
    private String riskLevel;
    private String weatherSummary;
    private String medicineSuggestion;
}