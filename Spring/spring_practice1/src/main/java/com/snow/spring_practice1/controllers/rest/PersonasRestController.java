package com.snow.spring_practice1.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snow.spring_practice1.models.Persona;
import com.snow.spring_practice1.services.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonasRestController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }
}
