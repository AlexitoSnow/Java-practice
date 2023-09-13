package com.snow.spring_practice1.tasks;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.snow.spring_practice1.services.ReunionService;

@Component
@Order(2) // Para que se ejecute después de DirectorioRunner
public class JuntasRunner implements ApplicationRunner{

    Logger LOG = LoggerFactory.getLogger(JuntasRunner.class);

    @Autowired
    private ReunionService reunionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Juntas pendientes");
        reunionService.getAllReuniones().forEach(r -> LOG.info(r.toString()));
        LOG.info("Fin de las juntas");
    }
    
}
