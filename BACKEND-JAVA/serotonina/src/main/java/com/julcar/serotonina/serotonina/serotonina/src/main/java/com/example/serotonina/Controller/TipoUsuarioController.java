package com.example.serotonina.Controller;

import com.example.serotonina.Entity.TipoUsuario;
import com.example.serotonina.Service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-usuarios")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    // GET todos los tipos de usuario
    @GetMapping
    public ResponseEntity<List<TipoUsuario>> consultarTiposUsuario() {
        return ResponseEntity.ok(tipoUsuarioService.consultarTiposUsuario());
    }

    // GET tipo de usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> buscarTipoUsuario(@PathVariable int id) {
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarTipoUsuario(id);
        if (tipoUsuario != null) {
            return ResponseEntity.ok(tipoUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST crear tipo de usuario
    @PostMapping
    public ResponseEntity<TipoUsuario> crearTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario nuevoTipoUsuario = tipoUsuarioService.crearTipoUsuario(tipoUsuario);
        return ResponseEntity.ok(nuevoTipoUsuario);
    }

    // PUT modificar tipo de usuario
    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> modificarTipoUsuario(@PathVariable int id, @RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarioModificado = tipoUsuarioService.modificarTipoUsuario(id, tipoUsuario);
        return ResponseEntity.ok(tipoUsuarioModificado);
    }

    // DELETE eliminar tipo de usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoUsuario(@PathVariable int id) {
        tipoUsuarioService.eliminarTipoUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
