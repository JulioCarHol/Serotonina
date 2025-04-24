package com.example.serotonina.Service;

import com.example.serotonina.Entity.Servicio;
import java.util.List;

public interface ServicioService {
    List<Servicio> consultarServicios();
    Servicio crearServicio(Servicio servicio);
    Servicio modificarServicio(int id, Servicio servicio);
    Servicio buscarServicio(int id);
    void eliminarServicio(int id);
} 