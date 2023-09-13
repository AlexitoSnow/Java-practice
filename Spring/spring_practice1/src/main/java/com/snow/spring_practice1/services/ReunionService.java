package com.snow.spring_practice1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.snow.spring_practice1.data.ReunionRepository;
import com.snow.spring_practice1.models.Reunion;

@Service
public class ReunionService {

    private final ReunionRepository reunionRepository;

    public ReunionService(ReunionRepository reunionRepository) {
        this.reunionRepository = reunionRepository;
    }

    public List<Reunion> getAllReuniones() {
        return reunionRepository.findAll();
    }
}
