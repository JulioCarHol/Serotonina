package com.example.serotonina.Service;

import com.example.serotonina.Entity.ResultadoPrueba;
import java.util.List;

public interface ResultadoPruebaService {
    List<ResultadoPrueba> consultarResultados();
    ResultadoPrueba crearResultado(ResultadoPrueba resultadoPrueba);
    ResultadoPrueba modificarResultado(int id, ResultadoPrueba resultadoPrueba);
    ResultadoPrueba buscarResultado(int id);
    void eliminarResultado(int id);
} 