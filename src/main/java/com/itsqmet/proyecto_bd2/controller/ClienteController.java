package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.entity.Cliente;
import com.itsqmet.proyecto_bd2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    //leer todos los clientes
    @GetMapping
    public List<Cliente> mostrarClientes() {
        return clienteService.allClientes();
    }

    //guardar nuevo cliente
    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }
    //Buscar Cliente por id
    @GetMapping("/{id}")
    public Optional<Cliente> buscarClienteId(@PathVariable Long id){
        return clienteService.buscarClienteId(id);
    }
    //actualizar cliente
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteService.buscarClienteId(id);
        if (clienteOptional.isPresent()) {
            Cliente clienteExiste = clienteOptional.get();
            clienteExiste.setNombre(cliente.getNombre());
            clienteExiste.setApellido(cliente.getApellido());
            clienteExiste.setCorreo(cliente.getCorreo());
            clienteExiste.setTelefono(cliente.getTelefono());
            clienteExiste.setPrestamos(cliente.getPrestamos());
            return clienteService.guardarCliente(clienteExiste);
        }
        return null;
    }

    //eliminar cliente
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
