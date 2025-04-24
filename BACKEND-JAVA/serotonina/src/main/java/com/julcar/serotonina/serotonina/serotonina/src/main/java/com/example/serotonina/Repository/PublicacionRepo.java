package com.example.serotonina.Repository;

import com.example.serotonina.Entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepo extends JpaRepository<Publicacion, Integer> {
} 