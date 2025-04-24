package com.example.serotonina.Service;

import com.example.serotonina.Entity.Publicacion;
import com.example.serotonina.Repository.PublicacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private PublicacionRepo publicacionRepo;

    @Override
    public List<Publicacion> consultarPublicaciones() {
        return publicacionRepo.findAll();
    }

    @Override
    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepo.save(publicacion);
    }

    @Override
    public Publicacion modificarPublicacion(int id, Publicacion publicacion) {
        Publicacion publicacionFromDB = publicacionRepo.findById(id).orElse(null);
        if (publicacionFromDB != null) {
            publicacionFromDB.setNombre(publicacion.getNombre());
            publicacionFromDB.setImagenUrl(publicacion.getImagenUrl());
            publicacionFromDB.setDescripcion(publicacion.getDescripcion());
            publicacionFromDB.setFechaPublicacion(publicacion.getFechaPublicacion());
            publicacionFromDB.setUsuario(publicacion.getUsuario());
            return publicacionRepo.save(publicacionFromDB);
        } else {
            throw new RuntimeException("La publicación con id " + id + " no fue encontrada.");
        }
    }

    @Override
    public Publicacion buscarPublicacion(int id) {
        return publicacionRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarPublicacion(int id) {
        publicacionRepo.deleteById(id);
    }
} 