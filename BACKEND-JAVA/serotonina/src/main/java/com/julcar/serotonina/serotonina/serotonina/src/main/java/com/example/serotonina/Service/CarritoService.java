package com.example.serotonina.Service;

import com.example.serotonina.Entity.Carrito;
import java.util.List;

public interface CarritoService {
    List<Carrito> consultarCarritos();
    Carrito crearCarrito(Carrito carrito);
    Carrito modificarCarrito(int id, Carrito carrito);
    Carrito buscarCarrito(int id_car);
    void eliminarCarrito(int id_car);
}