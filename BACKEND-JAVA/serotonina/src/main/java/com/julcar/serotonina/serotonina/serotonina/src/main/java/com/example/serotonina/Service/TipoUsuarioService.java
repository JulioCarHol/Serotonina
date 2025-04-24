package com.example.serotonina.Service;

import com.example.serotonina.Entity.TipoUsuario;
import java.util.List;

public interface TipoUsuarioService {
    List<TipoUsuario> consultarTiposUsuario();
    TipoUsuario crearTipoUsuario(TipoUsuario tipoUsuario);
    TipoUsuario modificarTipoUsuario(int id, TipoUsuario tipoUsuario);
    TipoUsuario buscarTipoUsuario(int id);
    void eliminarTipoUsuario(int id);
}
