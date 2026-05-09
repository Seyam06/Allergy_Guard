package com.Covix.AllergyGuard.Controller;

import com.Covix.AllergyGuard.Entity.AllergyRisk;
import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Repository.AllergyRiskRepository;
import com.Covix.AllergyGuard.Service.PersonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private AllergyRiskRepository riskRepo;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute("person") Person person, Model model) {
        String result = service.register(person);
        if (result.equals("Success")) {
            return "redirect:/login";
        }
        model.addAttribute("error", result);
        model.addAttribute("person", person);
        return "register";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login-process")
    public String loginProcess(@RequestParam String email,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {

        Person p = service.login(email, password);

        if (p != null) {
            session.setAttribute("user", p);
            return "redirect:/dashboard";
        }

        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        Person p = (Person) session.getAttribute("user");
        if (p == null) return "redirect:/login";

        String riskStatus = riskRepo.findFirstByPersonIdOrderByRiskIdDesc(p.getPerson_id())
                .map(AllergyRisk::getRiskLevel)
                .orElse("LOW");

        model.addAttribute("name", p.getName());
        model.addAttribute("age", p.getAge());
        model.addAttribute("riskStatus", riskStatus);

        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}