package com.example.serotonina.Service;

import com.example.serotonina.Entity.Servicio;
import com.example.serotonina.Repository.ServicioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepo servicioRepo;

    @Override
    public List<Servicio> consultarServicios() {
        return servicioRepo.findAll();
    }

    @Override
    public Servicio crearServicio(Servicio servicio) {
        return servicioRepo.save(servicio);
    }

    @Override
    public Servicio modificarServicio(int id, Servicio servicio) {
        Servicio servicioFromDB = servicioRepo.findById(id).orElse(null);
        if (servicioFromDB != null) {
            servicioFromDB.setTipoServ(servicio.getTipoServ());
            servicioFromDB.setPrecioServ(servicio.getPrecioServ());
            return servicioRepo.save(servicioFromDB);
        } else {
            throw new RuntimeException("El servicio con id " + id + " no fue encontrado.");
        }
    }

    @Override
    public Servicio buscarServicio(int id) {
        return servicioRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarServicio(int id) {
        servicioRepo.deleteById(id);
    }
} 