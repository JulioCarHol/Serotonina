package com.example.serotonina.Controller;

import com.example.serotonina.Entity.ResultadoPrueba;
import com.example.serotonina.Service.ResultadoPruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultados-prueba")
public class ResultadoPruebaController {

    @Autowired
    private ResultadoPruebaService resultadoPruebaService;

    // GET todos los resultados
    @GetMapping
    public ResponseEntity<List<ResultadoPrueba>> consultarResultados() {
        return ResponseEntity.ok(resultadoPruebaService.consultarResultados());
    }

    // GET resultado por id
    @GetMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> buscarResultado(@PathVariable int id) {
        ResultadoPrueba resultado = resultadoPruebaService.buscarResultado(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST crear resultado
    @PostMapping
    public ResponseEntity<ResultadoPrueba> crearResultado(@RequestBody ResultadoPrueba resultadoPrueba) {
        ResultadoPrueba nuevoResultado = resultadoPruebaService.crearResultado(resultadoPrueba);
        return ResponseEntity.ok(nuevoResultado);
    }

    // PUT modificar resultado
    @PutMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> modificarResultado(@PathVariable int id, @RequestBody ResultadoPrueba resultadoPrueba) {
        ResultadoPrueba resultadoModificado = resultadoPruebaService.modificarResultado(id, resultadoPrueba);
        return ResponseEntity.ok(resultadoModificado);
    }

    // DELETE eliminar resultado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResultado(@PathVariable int id) {
        resultadoPruebaService.eliminarResultado(id);
        return ResponseEntity.noContent().build();
    }
} 