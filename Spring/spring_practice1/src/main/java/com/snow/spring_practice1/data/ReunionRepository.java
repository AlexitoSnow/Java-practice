package com.snow.spring_practice1.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snow.spring_practice1.models.Reunion;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {

}
