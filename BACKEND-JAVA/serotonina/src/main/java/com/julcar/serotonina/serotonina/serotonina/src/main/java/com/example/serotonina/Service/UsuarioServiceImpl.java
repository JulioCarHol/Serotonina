package com.example.serotonina.Service;

import com.example.serotonina.Entity.Usuario;
import com.example.serotonina.Entity.TipoUsuario;
import com.example.serotonina.Repository.UsuarioRepo;
import com.example.serotonina.Repository.TipoUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private TipoUsuarioRepo tipoUsuarioRepo;

    @Override
    public List<Usuario> consultarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        // Validar que el tipo de usuario exista
        TipoUsuario tipoUsuario = usuario.getTipo_usuario();
        if (tipoUsuario != null) {
            int idTipoUsuario = tipoUsuario.getId_tipo_usu();
            TipoUsuario tipoUsuarioFromDB = tipoUsuarioRepo.findById(idTipoUsuario).orElse(null);
            if (tipoUsuarioFromDB != null) {
                usuario.setTipo_usuario(tipoUsuarioFromDB);
                return usuarioRepo.save(usuario);
            } else {
                throw new RuntimeException("El tipo de usuario con id " + idTipoUsuario + " no fue encontrado.");
            }
        } else {
            throw new RuntimeException("El usuario no tiene asignado un tipo de usuario.");
        }
    }

    @Override
    public Usuario modificarUsuario(int id, Usuario usuario) {
        Usuario usuarioFromDB = usuarioRepo.findById(id).orElse(null);
        if (usuarioFromDB != null) {
            usuarioFromDB.setNombre_usu(usuario.getNombre_usu());
            usuarioFromDB.setTelefono_usu(usuario.getTelefono_usu());
            usuarioFromDB.setCorreo_usu(usuario.getCorreo_usu());
            usuarioFromDB.setContrasenia_usu(usuario.getContrasenia_usu());
            // Validar tipo de usuario
            TipoUsuario tipoUsuario = usuario.getTipo_usuario();
            if (tipoUsuario != null) {
                int idTipoUsuario = tipoUsuario.getId_tipo_usu();
                TipoUsuario tipoUsuarioFromDB = tipoUsuarioRepo.findById(idTipoUsuario).orElse(null);
                if (tipoUsuarioFromDB != null) {
                    usuarioFromDB.setTipo_usuario(tipoUsuarioFromDB);
                } else {
                    throw new RuntimeException("El tipo de usuario con id " + idTipoUsuario + " no fue encontrado.");
                }
            }
            return usuarioRepo.save(usuarioFromDB);
        } else {
            throw new RuntimeException("El usuario con id " + id + " no fue encontrado.");
        }
    }

    @Override
    public Usuario buscarUsuario(int id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(int id) {
        usuarioRepo.deleteById(id);
    }
} 