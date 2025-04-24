package com.example.serotonina.Service;

import com.example.serotonina.Entity.ResultadoPrueba;
import com.example.serotonina.Repository.ResultadoPruebaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoPruebaServiceImpl implements ResultadoPruebaService {

    @Autowired
    private ResultadoPruebaRepo resultadoPruebaRepo;

    @Override
    public List<ResultadoPrueba> consultarResultados() {
        return resultadoPruebaRepo.findAll();
    }

    @Override
    public ResultadoPrueba crearResultado(ResultadoPrueba resultadoPrueba) {
        return resultadoPruebaRepo.save(resultadoPrueba);
    }

    @Override
    public ResultadoPrueba modificarResultado(int id, ResultadoPrueba resultadoPrueba) {
        ResultadoPrueba resultadoFromDB = resultadoPruebaRepo.findById(id).orElse(null);
        if (resultadoFromDB != null) {
            resultadoFromDB.setTipoPrueba(resultadoPrueba.getTipoPrueba());
            resultadoFromDB.setPuntaje(resultadoPrueba.getPuntaje());
            resultadoFromDB.setFechaRealizacion(resultadoPrueba.getFechaRealizacion());
            resultadoFromDB.setUsuario(resultadoPrueba.getUsuario());
            return resultadoPruebaRepo.save(resultadoFromDB);
        } else {
            throw new RuntimeException("El resultado de prueba con id " + id + " no fue encontrado.");
        }
    }

    @Override
    public ResultadoPrueba buscarResultado(int id) {
        return resultadoPruebaRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarResultado(int id) {
        resultadoPruebaRepo.deleteById(id);
    }
} 