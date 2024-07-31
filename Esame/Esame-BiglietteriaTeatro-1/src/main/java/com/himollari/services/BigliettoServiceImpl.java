package com.himollari.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himollari.entities.Biglietto;
import com.himollari.repos.BigliettoDAO;

@Service
public class BigliettoServiceImpl implements BigliettoService {

	@Autowired
	private BigliettoDAO bigliettoDAO;
	
	@Override
	public List<Biglietto> getAllBiglietti() {
		// TODO Auto-generated method stub
		return bigliettoDAO.findAll();
	}

	public Optional<Biglietto> getBigliettoById(String codOperazione) {
		// TODO Auto-generated method stub
		return bigliettoDAO.findById(codOperazione);
	}

	@Override
	public Biglietto addBiglietto(Biglietto biglietto) {
		// TODO Auto-generated method stub
		return bigliettoDAO.save(biglietto);
	}

	@Override
	public Biglietto updateBiglietto(Biglietto biglietto) {
		// TODO Auto-generated method stub
		return bigliettoDAO.save(biglietto);
	}

	@Override
	public void deleteBiglietto(String codOperazione) {
		// TODO Auto-generated method stub
		bigliettoDAO.deleteById(codOperazione);

	}

}
