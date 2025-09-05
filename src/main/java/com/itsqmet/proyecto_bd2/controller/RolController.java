package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.model.Rol;
import com.itsqmet.proyecto_bd2.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:5173")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> obtenerTodos() {
        return rolService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Rol> obtenerPorId(@PathVariable Integer id) {
        return rolService.obtenerPorId(id);
    }

    @PostMapping
    public Rol crear(@RequestBody Rol rol) {
        return rolService.guardar(rol);
    }

    @PutMapping("/{id}")
    public Rol actualizar(@PathVariable Integer id, @RequestBody Rol rol) {
        rol.setId(id);
        return rolService.guardar(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        rolService.eliminar(id);
    }
}
