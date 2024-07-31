package com.himollari.services;

import com.himollari.entities.Biglietto;

import java.util.List;
import java.util.Optional;

public interface BigliettoService {

    List<Biglietto> getAllBiglietti();

    Optional<Biglietto> getBigliettoById(String codOperazione);

    Biglietto addBiglietto(Biglietto biglietto);

    Biglietto updateBiglietto(Biglietto biglietto);

    void deleteBiglietto(String codOperazione);
}