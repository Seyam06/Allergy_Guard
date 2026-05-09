package com.Covix.AllergyGuard.Service;

import com.Covix.AllergyGuard.Entity.Person;
import com.Covix.AllergyGuard.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    public String register(Person p) {
        if (repo.findByEmail(p.getEmail()) != null) {
            return "Email already exists!";
        }
        repo.save(p);
        return "Success";
    }

    public Person login(String email, String password) {
        Person p = repo.findByEmail(email);
        if (p != null && p.getPassword().equals(password)) {
            return p;
        }
        return null;
    }
}