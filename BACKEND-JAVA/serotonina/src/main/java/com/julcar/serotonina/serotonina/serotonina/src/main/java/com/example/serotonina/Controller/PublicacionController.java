package com.example.serotonina.Controller;

import com.example.serotonina.Entity.Publicacion;
import com.example.serotonina.Service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    // GET todas las publicaciones
    @GetMapping
    public ResponseEntity<List<Publicacion>> consultarPublicaciones() {
        return ResponseEntity.ok(publicacionService.consultarPublicaciones());
    }

    // GET publicación por id
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> buscarPublicacion(@PathVariable int id) {
        Publicacion publicacion = publicacionService.buscarPublicacion(id);
        if (publicacion != null) {
            return ResponseEntity.ok(publicacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST crear publicación
    @PostMapping
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        Publicacion nuevaPublicacion = publicacionService.crearPublicacion(publicacion);
        return ResponseEntity.ok(nuevaPublicacion);
    }

    // PUT modificar publicación
    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> modificarPublicacion(@PathVariable int id, @RequestBody Publicacion publicacion) {
        Publicacion publicacionModificada = publicacionService.modificarPublicacion(id, publicacion);
        return ResponseEntity.ok(publicacionModificada);
    }

    // DELETE eliminar publicación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable int id) {
        publicacionService.eliminarPublicacion(id);
        return ResponseEntity.noContent().build();
    }
} 