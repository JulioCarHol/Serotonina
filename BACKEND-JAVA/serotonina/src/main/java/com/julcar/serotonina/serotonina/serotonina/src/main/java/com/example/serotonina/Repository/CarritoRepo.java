package com.example.serotonina.Repository;

import com.example.serotonina.Entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepo extends JpaRepository<Carrito, Integer> {
}