package com.example.serotonina.Service;

import com.example.serotonina.Entity.Producto;
import com.example.serotonina.Repository.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepo productoRepo;

    @Override
    public List<Producto> consultarProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public Producto modificarProducto(int id, Producto producto) {
        Producto productoFromDB = productoRepo.findById(id).orElse(null);
        if (productoFromDB != null) {
            productoFromDB.setTitulo(producto.getTitulo());
            productoFromDB.setDescripcion(producto.getDescripcion());
            productoFromDB.setPrecio(producto.getPrecio());
            productoFromDB.setImagen(producto.getImagen());
            productoFromDB.setEsServicio(producto.getEsServicio());
            return productoRepo.save(productoFromDB);
        } else {
            throw new RuntimeException("El producto con id " + id + " no fue encontrado.");
        }
    }

    @Override
    public Producto buscarProducto(int id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarProducto(int id) {
        productoRepo.deleteById(id);
    }
}