package com.example.serotonina.Service;

import com.example.serotonina.Entity.Terapeuta;
import java.util.List;

public interface TerapeutaService {
    List<Terapeuta> consultarTerapeutas();
    Terapeuta crearTerapeuta(Terapeuta terapeuta);
    Terapeuta modificarTerapeuta(int id, Terapeuta terapeuta);
    Terapeuta buscarTerapeuta(int id);
    void eliminarTerapeuta(int id);
} 