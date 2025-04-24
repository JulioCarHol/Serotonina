package com.example.serotonina.Controller;

import com.example.serotonina.Entity.Carrito;
import com.example.serotonina.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // GET todos los carritos
    @GetMapping
    public ResponseEntity<List<Carrito>> consultarCarritos() {
        return ResponseEntity.ok(carritoService.consultarCarritos());
    }

    // GET carrito por id
    @GetMapping("/{id}")
    public ResponseEntity<Carrito> buscarCarrito(@PathVariable int id) {
        Carrito carrito = carritoService.buscarCarrito(id);
        if (carrito != null) {
            return ResponseEntity.ok(carrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST crear carrito
    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito) {
        Carrito nuevoCarrito = carritoService.crearCarrito(carrito);
        return ResponseEntity.ok(nuevoCarrito);
    }

    // PUT modificar carrito
    @PutMapping("/{id}")
    public ResponseEntity<Carrito> modificarCarrito(@PathVariable int id, @RequestBody Carrito carrito) {
        Carrito carritoModificado = carritoService.modificarCarrito(id, carrito);
        return ResponseEntity.ok(carritoModificado);
    }

    // DELETE eliminar carrito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable int id) {
        carritoService.eliminarCarrito(id);
        return ResponseEntity.noContent().build();
    }
}