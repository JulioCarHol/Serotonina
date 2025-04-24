package com.example.serotonina.Controller;

import com.example.serotonina.Entity.Terapeuta;
import com.example.serotonina.Service.TerapeutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terapeutas")
public class TerapeutaController {

    @Autowired
    private TerapeutaService terapeutaService;

    // GET todos los terapeutas
    @GetMapping
    public ResponseEntity<List<Terapeuta>> consultarTerapeutas() {
        return ResponseEntity.ok(terapeutaService.consultarTerapeutas());
    }

    // GET terapeuta por id
    @GetMapping("/{id}")
    public ResponseEntity<Terapeuta> buscarTerapeuta(@PathVariable int id) {
        Terapeuta terapeuta = terapeutaService.buscarTerapeuta(id);
        if (terapeuta != null) {
            return ResponseEntity.ok(terapeuta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST crear terapeuta
    @PostMapping
    public ResponseEntity<Terapeuta> crearTerapeuta(@RequestBody Terapeuta terapeuta) {
        Terapeuta nuevoTerapeuta = terapeutaService.crearTerapeuta(terapeuta);
        return ResponseEntity.ok(nuevoTerapeuta);
    }

    // PUT modificar terapeuta
    @PutMapping("/{id}")
    public ResponseEntity<Terapeuta> modificarTerapeuta(@PathVariable int id, @RequestBody Terapeuta terapeuta) {
        Terapeuta terapeutaModificado = terapeutaService.modificarTerapeuta(id, terapeuta);
        return ResponseEntity.ok(terapeutaModificado);
    }

    // DELETE eliminar terapeuta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTerapeuta(@PathVariable int id) {
        terapeutaService.eliminarTerapeuta(id);
        return ResponseEntity.noContent().build();
    }
} 