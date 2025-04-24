package com.example.serotonina.Controller;

import com.example.serotonina.Entity.Usuario;
import com.example.serotonina.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> consultarUsuarios() {
        return ResponseEntity.ok(usuarioService.consultarUsuarios());
    }

    // GET usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable int id) {
        Usuario usuario = usuarioService.buscarUsuario(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST crear usuario
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // PUT modificar usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario usuarioModificado = usuarioService.modificarUsuario(id, usuario);
        return ResponseEntity.ok(usuarioModificado);
    }

    // DELETE eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
} 