package com.example.serotonina.Service;

import com.example.serotonina.Entity.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> consultarUsuarios();
    Usuario crearUsuario(Usuario usuario);
    Usuario modificarUsuario(int id, Usuario usuario);
    Usuario buscarUsuario(int id);
    void eliminarUsuario(int id);
}
