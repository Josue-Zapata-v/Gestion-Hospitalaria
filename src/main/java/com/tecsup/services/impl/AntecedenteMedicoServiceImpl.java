package com.tecsup.services.impl;

import com.tecsup.model.daos.AntecedenteMedicoRepository;
import com.tecsup.model.entities.AntecedenteMedico;
import com.tecsup.services.AntecedenteMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedenteMedicoServiceImpl implements AntecedenteMedicoService {

    @Autowired
    private AntecedenteMedicoRepository dao;

    @Override
    public List<AntecedenteMedico> findAllAntecedentes() {
        return (List<AntecedenteMedico>) dao.findAll();
    }

    @Override
    public AntecedenteMedico findByIdAntecedente(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void saveAntecedente(AntecedenteMedico antecedenteMedico) {
        dao.save(antecedenteMedico);
    }

    @Override
    public void deleteAntecedente(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<AntecedenteMedico> findByHistoriaClinicaId(int idHistoria) {
        return dao.findByHistoriaClinicaIdHistoria(idHistoria);
    }
}
