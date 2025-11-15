package com.example.inventory.controller;

import com.example.inventory.model.Movimiento;
import com.example.inventory.model.Producto;
import com.example.inventory.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventarioController {

    @Autowired
    private InventarioService service;

    @PostMapping("/producto")
    public Producto crearProducto(@RequestBody Producto p) {
        return service.crearProducto(p);
    }

    @GetMapping("/inventario")
    public List<Producto> inventario() {
        return service.consultarInventario();
    }

    @PostMapping("/entrada/{id}/{cantidad}")
    public Movimiento entrada(@PathVariable Long id, @PathVariable Integer cantidad) {
        return service.entrada(id, cantidad);
    }

    @PostMapping("/salida/{id}/{cantidad}")
    public Movimiento salida(@PathVariable Long id, @PathVariable Integer cantidad) {
        return service.salida(id, cantidad);
    }

    @GetMapping("/historial")
    public List<Movimiento> historial() {
        return service.historial();
    }
}
