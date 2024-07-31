package com.himollari.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himollari.entities.Spettacolo;
import com.himollari.repos.SpettacoloDAO;
@Service
public class SpettacoloServiceImpl implements SpettacoloService {

	    @Autowired
	    private SpettacoloDAO spettacoloDAO;

	    @Override
	    public List<Spettacolo> getAllSpettacoli() {
	        return spettacoloDAO.findAll();
	    }

	    @Override
	    public Optional<Spettacolo> getSpettacoloById(String codSpettacolo) {
	        return spettacoloDAO.findById(codSpettacolo);
	    }

	    @Override
	    public Spettacolo addSpettacolo(Spettacolo spettacolo) {
	        return spettacoloDAO.save(spettacolo);
	    }

	    @Override
	    public Spettacolo updateSpettacolo(Spettacolo spettacolo) {
	        return spettacoloDAO.save(spettacolo);
	    }

	    @Override
	    public void deleteSpettacolo(String codSpettacolo) {
	        spettacoloDAO.deleteById(codSpettacolo);
	    }
}
