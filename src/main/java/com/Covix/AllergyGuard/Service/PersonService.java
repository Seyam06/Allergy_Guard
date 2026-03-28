package com.Covix.AllergyGuard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    public String register(Person p) {
        repo.save(p);
        return "Registered";
    }

    public Person login(String email, String password) {
        Person p = repo.findByEmail(email);
        if (p != null && password.equals(p.getPassword())) {
            return p; // login success
        }
        return null; // login failed
    }
}