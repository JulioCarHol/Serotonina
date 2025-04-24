package com.example.serotonina.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "resultado_prueba")
public class ResultadoPrueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Tipo de prueba: ansiedad, autoestima, depresion, estres, etc.
    @Column(name = "tipo_prueba", nullable = false, length = 50)
    private String tipoPrueba;

    @Column(name = "puntaje", nullable = false)
    private int puntaje;

    @Column(name = "fecha_realizacion", nullable = false)
    private LocalDateTime fechaRealizacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}