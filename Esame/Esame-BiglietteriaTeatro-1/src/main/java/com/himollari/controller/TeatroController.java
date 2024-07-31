package com.himollari.controller;

import com.himollari.entities.Teatro;
import com.himollari.services.TeatroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teatri")
public class TeatroController {

    @Autowired
    private TeatroService teatroService;

    @GetMapping
    public ResponseEntity<List<Teatro>> getAllTeatri() {
        List<Teatro> teatri = teatroService.getAllTeatri();
        return new ResponseEntity<>(teatri, HttpStatus.OK);
    }

    @GetMapping("/{codTeatro}")
    public ResponseEntity<Teatro> getTeatroById(@PathVariable String codTeatro) {
        Optional<Teatro> teatro = teatroService.getTeatroById(codTeatro);
        return teatro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teatro> addTeatro(@RequestBody Teatro teatro) {
        Teatro addedTeatro = teatroService.addTeatro(teatro);
        return new ResponseEntity<>(addedTeatro, HttpStatus.CREATED);
    }

    @PutMapping("/{codTeatro}")
    public ResponseEntity<Teatro> updateTeatro(
            @PathVariable String codTeatro,
            @RequestBody Teatro teatro
    ) {
        teatro.setCodTeatro(codTeatro);
        try {
            Teatro updatedTeatro = teatroService.updateTeatro(teatro);
            return new ResponseEntity<>(updatedTeatro, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codTeatro}")
    public ResponseEntity<Void> deleteTeatro(@PathVariable String codTeatro) {
        try {
            teatroService.deleteTeatro(codTeatro);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
