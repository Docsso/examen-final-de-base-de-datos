package com.example.inventory.service;

import com.example.inventory.model.Movimiento;
import com.example.inventory.model.Producto;
import com.example.inventory.repository.MovimientoRepository;
import com.example.inventory.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventarioService {
    @Autowired
    private ProductoRepository productoRepo;
    @Autowired
    private MovimientoRepository movRepo;

    public Producto crearProducto(Producto p) {
        return productoRepo.save(p);
    }

    public List<Producto> consultarInventario() {
        return productoRepo.findAll();
    }

    public Movimiento entrada(Long idProducto, Integer cantidad) {
        Producto p = productoRepo.findById(idProducto).orElseThrow();
        p.setCantidadActual(p.getCantidadActual() + cantidad);

        Movimiento m = new Movimiento();
        m.setProducto(p);
        m.setCantidad(cantidad);
        m.setTipo("ENTRADA");
        m.setFecha(LocalDateTime.now());

        productoRepo.save(p);
        return movRepo.save(m);
    }

    public Movimiento salida(Long idProducto, Integer cantidad) {
        Producto p = productoRepo.findById(idProducto).orElseThrow();
        p.setCantidadActual(p.getCantidadActual() - cantidad);

        Movimiento m = new Movimiento();
        m.setProducto(p);
        m.setCantidad(cantidad);
        m.setTipo("SALIDA");
        m.setFecha(LocalDateTime.now());

        productoRepo.save(p);
        return movRepo.save(m);
    }

    public List<Movimiento> historial() {
        return movRepo.findAll();
    }
}
