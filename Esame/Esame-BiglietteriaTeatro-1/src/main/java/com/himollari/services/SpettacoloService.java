package com.himollari.services;


import com.himollari.entities.Spettacolo;

import java.util.List;
import java.util.Optional;

public interface SpettacoloService {

    List<Spettacolo> getAllSpettacoli();

    Optional<Spettacolo> getSpettacoloById(String codSpettacolo);

    Spettacolo addSpettacolo(Spettacolo spettacolo);

    Spettacolo updateSpettacolo(Spettacolo spettacolo);

    void deleteSpettacolo(String codSpettacolo);
}