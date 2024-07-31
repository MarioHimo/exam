package com.himollari.controller;

import com.himollari.entities.Cliente;
import com.himollari.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClienti() {
    	System.out.println("------------------------test----------------------------------");
        List<Cliente> clienti = clienteService.getAllClienti();
        return new ResponseEntity<>(clienti, HttpStatus.OK);
    }

    @GetMapping("/{codCliente}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int codCliente) {
        Optional<Cliente> cliente = clienteService.getClienteById(codCliente);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente addedCliente = clienteService.addCliente(cliente);
        return new ResponseEntity<>(addedCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{codCliente}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable int codCliente,
            @RequestBody Cliente cliente
    ) {
        cliente.setCodCliente(codCliente);
        try {
            Cliente updatedCliente = clienteService.updateCliente(cliente);
            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codCliente}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int codCliente) {
        try {
            clienteService.deleteCliente(codCliente);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

