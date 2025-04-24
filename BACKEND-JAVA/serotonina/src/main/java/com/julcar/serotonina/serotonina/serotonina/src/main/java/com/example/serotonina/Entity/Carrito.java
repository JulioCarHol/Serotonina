package com.example.serotonina.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private int id_car;

    @Column(name = "total_car")
    private double total_car;

    @ManyToOne
    @JoinColumn(name = "usuarios_id_usu")
    private Usuario usuario;
} 