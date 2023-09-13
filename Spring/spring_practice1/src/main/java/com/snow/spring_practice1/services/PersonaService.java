package com.snow.spring_practice1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.snow.spring_practice1.data.PersonaRepository;
import com.snow.spring_practice1.models.Persona;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
}
