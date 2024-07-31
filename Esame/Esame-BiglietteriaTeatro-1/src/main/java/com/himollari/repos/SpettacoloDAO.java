package com.himollari.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.himollari.entities.Spettacolo;

@Repository
public interface SpettacoloDAO extends JpaRepository<Spettacolo, String> {

}
