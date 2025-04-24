package com.example.serotonina.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serv")
    private int idServ;

    @Column(name = "tipo_serv")
    private String tipoServ;

    @Column(name = "precio_serv")
    private double precioServ;
}