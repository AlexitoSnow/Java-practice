package com.snow.spring_practice1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snow.spring_practice1.services.ReunionService;

@Controller // Se especifica a SpringBoot que es un controlador
@RequestMapping("/reuniones") // Se especifica la ruta a la que responde
public class ReunionController {

    @Autowired // Se inyecta el servicio
    private ReunionService reunionService;

    @GetMapping // Responde a las peticiones GET
    public String getAllReuniones(Model model) {
        model.addAttribute("reuniones", reunionService.getAllReuniones());
        return "reuniones";
    }
}
