package com.example.serotonina.Repository;

import com.example.serotonina.Entity.Terapeuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerapeutaRepo extends JpaRepository<Terapeuta, Integer> {
} 