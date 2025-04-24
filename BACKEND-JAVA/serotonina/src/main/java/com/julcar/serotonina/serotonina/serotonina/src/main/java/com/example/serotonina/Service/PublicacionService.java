package com.example.serotonina.Service;

import com.example.serotonina.Entity.Publicacion;
import java.util.List;

public interface PublicacionService {
    List<Publicacion> consultarPublicaciones();
    Publicacion crearPublicacion(Publicacion publicacion);
    Publicacion modificarPublicacion(int id, Publicacion publicacion);
    Publicacion buscarPublicacion(int id);
    void eliminarPublicacion(int id);
} 