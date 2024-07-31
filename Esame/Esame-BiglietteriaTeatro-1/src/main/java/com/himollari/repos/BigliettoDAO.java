package com.himollari.repos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.himollari.entities.Biglietto;

@Repository
public interface BigliettoDAO extends JpaRepository<Biglietto, String> {
}

