package com.tecsup.services.impl;

import com.tecsup.model.daos.HistoriaClinicaRepository;
import com.tecsup.model.entities.HistoriaClinica;
import com.tecsup.services.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository dao;

    @Override
    public List<HistoriaClinica> findAllHistorias() {
        return (List<HistoriaClinica>) dao.findAll();
    }

    @Override
    public HistoriaClinica findByIdHistoria(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void saveHistoria(HistoriaClinica historiaClinica) {
        dao.save(historiaClinica);
    }

    @Override
    public void deleteHistoria(int id) {
        dao.deleteById(id);
    }

    @Override
    public HistoriaClinica findByPacienteId(int idPaciente) {
        return dao.findByPacienteIdPaciente(idPaciente);
    }
}
