package com.snow.spring_practice1.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.snow.spring_practice1.services.PersonaService;

// Esta clase se ejecuta al iniciar la aplicación
@Component // Para que Spring lo detecte como un componente
@Order(1) // Para que se ejecute antes de JuntasRunner
public class DirectorioRunner implements CommandLineRunner {
    private final Logger LOG = LoggerFactory.getLogger(DirectorioRunner.class);

    @Autowired
    private PersonaService personaService;

    // Implementa run de CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        LOG.info("Directorio de personas");
        personaService.getAllPersonas().forEach(p -> LOG.info(p.toString()));
        LOG.info("Fin del directorio");
    }

}
