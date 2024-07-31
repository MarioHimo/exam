package com.himollari.controller;

import com.himollari.entities.Replica;
import com.himollari.services.ReplicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/repliche")
public class ReplicaController {

    @Autowired
    private ReplicaService replicaService;

    @GetMapping
    public ResponseEntity<List<Replica>> getAllRepliche() {
        List<Replica> repliche = replicaService.getAllRepliche();
        return new ResponseEntity<>(repliche, HttpStatus.OK);
    }

    @GetMapping("/{codReplica}")
    public ResponseEntity<Replica> getReplicaById(@PathVariable String codReplica) {
        Optional<Replica> replica = replicaService.getReplicaById(codReplica);
        return replica.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Replica> addReplica(@RequestBody Replica replica) {
        Replica addedReplica = replicaService.addReplica(replica);
        return new ResponseEntity<>(addedReplica, HttpStatus.CREATED);
    }

    @PutMapping("/{codReplica}")
    public ResponseEntity<Replica> updateReplica(
            @PathVariable String codReplica,
            @RequestBody Replica replica
    ) {
        replica.setCodReplica(codReplica);
        try {
            Replica updatedReplica = replicaService.updateReplica(replica);
            return new ResponseEntity<>(updatedReplica, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codReplica}")
    public ResponseEntity<Void> deleteReplica(@PathVariable String codReplica) {
        try {
            replicaService.deleteReplica(codReplica);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

