package com.himollari.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.himollari.entities.Replica;

@Repository
public interface ReplicaDAO extends JpaRepository<Replica, String> {
}
