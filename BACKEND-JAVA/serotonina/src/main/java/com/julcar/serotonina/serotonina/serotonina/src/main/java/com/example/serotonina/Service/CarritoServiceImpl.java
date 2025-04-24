package com.example.serotonina.Service;

import com.example.serotonina.Entity.Carrito;
import com.example.serotonina.Repository.CarritoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoRepo carritoRepo;

    @Override
    public List<Carrito> consultarCarritos() {
        return carritoRepo.findAll();
    }

    @Override
    public Carrito crearCarrito(Carrito carrito) {
        return carritoRepo.save(carrito);
    }

    @Override
    public Carrito modificarCarrito(int id, Carrito carrito) {
        Carrito carritoFromDB = carritoRepo.findById(id).orElse(null);
        if (carritoFromDB != null) {
            carritoFromDB.setTotal_car(carrito.getTotal_car());
            carritoFromDB.setUsuario(carrito.getUsuario());
            return carritoRepo.save(carritoFromDB);
        } else {
            throw new RuntimeException("El carrito con id " + id + " no fue encontrado.");
        }
    }

    @Override
    public Carrito buscarCarrito(int id_car) {
        return carritoRepo.findById(id_car).orElse(null);
    }

    @Override
    public void eliminarCarrito(int id_car) {
        carritoRepo.deleteById(id_car);
    }
}