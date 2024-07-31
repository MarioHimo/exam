package com.himollari.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himollari.entities.Teatro;
import com.himollari.repos.TeatroDAO;
@Service
public class TeatroServiceImpl implements TeatroService {

	@Autowired
    private TeatroDAO teatroDAO;

    @Override
    public List<Teatro> getAllTeatri() {
        return teatroDAO.findAll();
    }

    @Override
    public Optional<Teatro> getTeatroById(String codTeatro) {
        return teatroDAO.findById(codTeatro);
    }

    @Override
    public Teatro addTeatro(Teatro teatro) {
        return teatroDAO.save(teatro);
    }

    @Override
    public Teatro updateTeatro(Teatro teatro) {
        return teatroDAO.save(teatro);
    }

    @Override
    public void deleteTeatro(String codTeatro) {
        teatroDAO.deleteById(codTeatro);
    }
}
