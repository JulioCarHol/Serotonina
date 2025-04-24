package com.example.serotonina.Repository;

import com.example.serotonina.Entity.ResultadoPrueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoPruebaRepo extends JpaRepository<ResultadoPrueba, Integer> {
} 