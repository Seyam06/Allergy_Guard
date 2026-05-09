package com.Covix.AllergyGuard.Controller;

import com.Covix.AllergyGuard.Dto.MedicalHistoryDTO;
import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Service.MedicalHistoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private MedicalHistoryService historyService;

    @GetMapping("/timeline")
    public List<MedicalHistoryDTO> getMedicalTimeline(HttpSession session) {
        Person user = (Person) session.getAttribute("user");
        if (user == null) return null;
        return historyService.getTimeline(user);
    }
}