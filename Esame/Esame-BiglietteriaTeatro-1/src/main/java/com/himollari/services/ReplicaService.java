package com.himollari.services;

import com.himollari.entities.Replica;

import java.util.List;
import java.util.Optional;

public interface ReplicaService {

    List<Replica> getAllRepliche();

    Optional<Replica> getReplicaById(String codReplica);

    Replica addReplica(Replica replica);

    Replica updateReplica(Replica replica);

    void deleteReplica(String codReplica);
}
