package com.example.serotonina.Service;

import com.example.serotonina.Entity.Terapeuta;
import com.example.serotonina.Repository.TerapeutaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerapeutaServiceImpl implements TerapeutaService {

    @Autowired
    private TerapeutaRepo terapeutaRepo;

    @Override
    public List<Terapeuta> consultarTerapeutas() {
        return terapeutaRepo.findAll();
    }

    @Override
    public Terapeuta crearTerapeuta(Terapeuta terapeuta) {
        return terapeutaRepo.save(terapeuta);
    }

    @Override
    public Terapeuta modificarTerapeuta(int id, Terapeuta terapeuta) {
        Terapeuta terapeutaFromDB = terapeutaRepo.findById(id).orElse(null);
        if (terapeutaFromDB != null) {
            terapeutaFromDB.setNombre(terapeuta.getNombre());
            terapeutaFromDB.setTipoTerapia(terapeuta.getTipoTerapia());
            terapeutaFromDB.setEmail(terapeuta.getEmail());
            terapeutaFromDB.setTelefono(terapeuta.getTelefono());
            terapeutaFromDB.setFotoUrl(terapeuta.getFotoUrl());
            return terapeutaRepo.save(terapeutaFromDB);
        } else {
            throw new RuntimeException("El terapeuta con id " + id + " no fue encontrado.");
        }
    }

    @Override
    public Terapeuta buscarTerapeuta(int id) {
        return terapeutaRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarTerapeuta(int id) {
        terapeutaRepo.deleteById(id);
    }
} 