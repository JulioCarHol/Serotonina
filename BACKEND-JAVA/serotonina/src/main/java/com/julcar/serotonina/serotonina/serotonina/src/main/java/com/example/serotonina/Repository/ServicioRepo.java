package com.example.serotonina.Repository;

import com.example.serotonina.Entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepo extends JpaRepository<Servicio, Integer> {
} 