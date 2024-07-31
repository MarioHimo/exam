package com.himollari.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himollari.entities.Replica;
import com.himollari.repos.ReplicaDAO;
@Service
public class ReplicaServiceImpl implements ReplicaService {


    @Autowired
    private ReplicaDAO replicaDAO;

    @Override
    public List<Replica> getAllRepliche() {
        return replicaDAO.findAll();
    }

    @Override
    public Optional<Replica> getReplicaById(String codReplica) {
        return replicaDAO.findById(codReplica);
    }

    @Override
    public Replica addReplica(Replica replica) {
        return replicaDAO.save(replica);
    }

    @Override
    public Replica updateReplica(Replica replica) {
        return replicaDAO.save(replica);
    }

    @Override
    public void deleteReplica(String codReplica) {
        replicaDAO.deleteById(codReplica);
    }
}
