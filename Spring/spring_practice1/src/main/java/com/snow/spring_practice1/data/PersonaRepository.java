package com.snow.spring_practice1.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snow.spring_practice1.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
