package com.itsqmet.proyecto_bd2.service;

import com.itsqmet.proyecto_bd2.entity.Cliente;
import com.itsqmet.proyecto_bd2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    //Lista de clientes
    public List<Cliente> allClientes(){
        return clienteRepository.findAll();
    }

    //buscar por id(para actualizar y eliminar)
    public Optional<Cliente> buscarClienteId(Long id){
        return clienteRepository.findById(id);
    }
    //Guardar cliente
    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    //Eliminar cliente
    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
