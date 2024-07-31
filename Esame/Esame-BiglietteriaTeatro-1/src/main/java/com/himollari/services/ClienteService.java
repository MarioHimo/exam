
package com.himollari.services;

import com.himollari.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> getAllClienti();

    Optional<Cliente> getClienteById(int codCliente);

    Cliente addCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente);

    void deleteCliente(int codCliente);
}

