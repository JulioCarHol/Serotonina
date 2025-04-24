package com.example.serotonina.Controller;

import com.example.serotonina.Entity.Servicio;
import com.example.serotonina.Service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // GET todos los servicios
    @GetMapping
    public ResponseEntity<List<Servicio>> consultarServicios() {
        return ResponseEntity.ok(servicioService.consultarServicios());
    }

    // GET servicio por id
    @GetMapping("/{id}")
    public ResponseEntity<Servicio> buscarServicio(@PathVariable int id) {
        Servicio servicio = servicioService.buscarServicio(id);
        if (servicio != null) {
            return ResponseEntity.ok(servicio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST crear servicio
    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        Servicio nuevoServicio = servicioService.crearServicio(servicio);
        return ResponseEntity.ok(nuevoServicio);
    }

    // PUT modificar servicio
    @PutMapping("/{id}")
    public ResponseEntity<Servicio> modificarServicio(@PathVariable int id, @RequestBody Servicio servicio) {
        Servicio servicioModificado = servicioService.modificarServicio(id, servicio);
        return ResponseEntity.ok(servicioModificado);
    }

    // DELETE eliminar servicio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable int id) {
        servicioService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }
} 