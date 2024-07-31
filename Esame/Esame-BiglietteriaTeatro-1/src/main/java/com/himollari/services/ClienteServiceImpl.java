package com.himollari.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himollari.entities.Cliente;
import com.himollari.repos.ClienteDAO;

@Service
public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public List<Cliente> getAllClienti() {
        return clienteDAO.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(int codCliente) {
        return clienteDAO.findById(codCliente);
    }

    @Override
    public Cliente addCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public void deleteCliente(int codCliente) {
        clienteDAO.deleteById(codCliente);
    }
}
