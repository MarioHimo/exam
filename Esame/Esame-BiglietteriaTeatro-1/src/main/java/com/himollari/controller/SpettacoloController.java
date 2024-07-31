package com.himollari.controller;

import com.himollari.entities.Spettacolo;
import com.himollari.services.SpettacoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/spettacoli")
public class SpettacoloController {

    @Autowired
    private SpettacoloService spettacoloService;

    @GetMapping
    public ResponseEntity<List<Spettacolo>> getAllSpettacoli() {
        List<Spettacolo> spettacoli = spettacoloService.getAllSpettacoli();
        return new ResponseEntity<>(spettacoli, HttpStatus.OK);
    }

    @GetMapping("/{codSpettacolo}")
    public ResponseEntity<Spettacolo> getSpettacoloById(@PathVariable String codSpettacolo) {
        Optional<Spettacolo> spettacolo = spettacoloService.getSpettacoloById(codSpettacolo);
        return spettacolo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Spettacolo> addSpettacolo(@RequestBody Spettacolo spettacolo) {
        Spettacolo addedSpettacolo = spettacoloService.addSpettacolo(spettacolo);
        return new ResponseEntity<>(addedSpettacolo, HttpStatus.CREATED);
    }

    @PutMapping("/{codSpettacolo}")
    public ResponseEntity<Spettacolo> updateSpettacolo(
            @PathVariable String codSpettacolo,
            @RequestBody Spettacolo spettacolo
    ) {
        spettacolo.setCodSpettacolo(codSpettacolo);
        try {
            Spettacolo updatedSpettacolo = spettacoloService.updateSpettacolo(spettacolo);
            return new ResponseEntity<>(updatedSpettacolo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codSpettacolo}")
    public ResponseEntity<Void> deleteSpettacolo(@PathVariable String codSpettacolo) {
        try {
            spettacoloService.deleteSpettacolo(codSpettacolo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
