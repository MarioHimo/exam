package com.himollari.controller;

import com.himollari.entities.Biglietto;
import com.himollari.services.BigliettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/biglietti")
public class BigliettoController {

    @Autowired
    private BigliettoService bigliettoService;

    @GetMapping
    public ResponseEntity<List<Biglietto>> getAllBiglietti() {
        List<Biglietto> biglietti = bigliettoService.getAllBiglietti();
        return new ResponseEntity<>(biglietti, HttpStatus.OK);
    }

    @GetMapping("/{codOperazione}")
    public ResponseEntity<Biglietto> getBigliettoById(@PathVariable String codOperazione) {
        Optional<Biglietto> biglietto = bigliettoService.getBigliettoById(codOperazione);
        return biglietto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Biglietto> addBiglietto(@RequestBody Biglietto biglietto) {
        Biglietto addedBiglietto = bigliettoService.addBiglietto(biglietto);
        return new ResponseEntity<>(addedBiglietto, HttpStatus.CREATED);
    }

    @PutMapping("/{codOperazione}")
    public ResponseEntity<Biglietto> updateBiglietto(
            @PathVariable String codOperazione,
            @RequestBody Biglietto biglietto
    ) {
        biglietto.setCodOperazione(codOperazione);
        try {
            Biglietto updatedBiglietto = bigliettoService.updateBiglietto(biglietto);
            return new ResponseEntity<>(updatedBiglietto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codOperazione}")
    public ResponseEntity<Void> deleteBiglietto(@PathVariable String codOperazione) {
        try {
            bigliettoService.deleteBiglietto(codOperazione);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
