package com.example.serotonina.Controller;

import com.example.serotonina.Entity.Producto;
import com.example.serotonina.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // GET todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> consultarProductos() {
        return ResponseEntity.ok(productoService.consultarProductos());
    }

    // GET producto por id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable int id) {
        Producto producto = productoService.buscarProducto(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST crear producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    // PUT modificar producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> modificarProducto(@PathVariable int id, @RequestBody Producto producto) {
        Producto productoModificado = productoService.modificarProducto(id, producto);
        return ResponseEntity.ok(productoModificado);
    }

    // DELETE eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}