package com.example.serotonina.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "terapeutas")
public class Terapeuta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo_terapia", nullable = false)
    private String tipoTerapia;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "foto_url")
    private String fotoUrl;
}