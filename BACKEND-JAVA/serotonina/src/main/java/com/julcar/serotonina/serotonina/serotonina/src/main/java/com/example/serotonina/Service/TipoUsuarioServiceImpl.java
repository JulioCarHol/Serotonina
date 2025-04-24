package com.example.serotonina.Service;

import com.example.serotonina.Entity.TipoUsuario;
import com.example.serotonina.Repository.TipoUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepo tipoUsuarioRepo;

    @Override
    public List<TipoUsuario> consultarTiposUsuario() {
        return tipoUsuarioRepo.findAll();
    }

    @Override
    public TipoUsuario crearTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepo.save(tipoUsuario);
    }

    @Override
    public TipoUsuario modificarTipoUsuario(int id, TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarioFromDB = tipoUsuarioRepo.findById(id).orElse(null);
        if (tipoUsuarioFromDB != null) {
            tipoUsuarioFromDB.setTipo_usu(tipoUsuario.getTipo_usu());
            return tipoUsuarioRepo.save(tipoUsuarioFromDB);
        } else {
            throw new RuntimeException("El tipo de usuario con id " + id + " no fue encontrado.");
        }
    }

    @Override
    public TipoUsuario buscarTipoUsuario(int id) {
        return tipoUsuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarTipoUsuario(int id) {
        tipoUsuarioRepo.deleteById(id);
    }
} 