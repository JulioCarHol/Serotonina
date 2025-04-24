package com.example.serotonina.Service;

import com.example.serotonina.Entity.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> consultarProductos();
    Producto crearProducto(Producto producto);
    Producto modificarProducto(int id, Producto producto);
    Producto buscarProducto(int id);
    void eliminarProducto(int id);
}