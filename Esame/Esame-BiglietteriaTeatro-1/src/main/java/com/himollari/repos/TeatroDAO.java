package com.himollari.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.himollari.entities.Teatro;

@Repository
public interface TeatroDAO extends JpaRepository<Teatro, String> {

}
