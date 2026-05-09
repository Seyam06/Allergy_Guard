package com.Covix.AllergyGuard.Controller;

import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Service.SymptomService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/symptoms")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @PostMapping("/save")
    public ResponseEntity<?> saveSymptoms(@RequestBody Map<String, List<String>> payload, HttpSession session) {
        Person loggedInUser = (Person) session.getAttribute("user");

        if (loggedInUser == null) {
            return ResponseEntity.status(401).body("User not logged in");
        }

        List<String> symptoms = payload.get("symptoms");
        symptomService.linkSymptomToUser(loggedInUser, symptoms);

        return ResponseEntity.ok("Symptoms saved successfully!");
    }
}