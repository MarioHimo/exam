package com.himollari.services;

import com.himollari.entities.Teatro;

import java.util.List;
import java.util.Optional;

public interface TeatroService {

    List<Teatro> getAllTeatri();

    Optional<Teatro> getTeatroById(String codTeatro);

    Teatro addTeatro(Teatro teatro);

    Teatro updateTeatro(Teatro teatro);

    void deleteTeatro(String codTeatro);
}
