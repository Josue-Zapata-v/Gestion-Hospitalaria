package com.tecsup.services.impl;

import com.tecsup.model.daos.PacienteRepository;
import com.tecsup.model.entities.HistoriaClinica;
import com.tecsup.model.entities.Paciente;
import com.tecsup.services.PacienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository dao;

    @Override
    public List<Paciente> findAllPacientes() {
        return (List<Paciente>) dao.findAll();
    }

    @Override
    public Paciente findByIdPaciente(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override // Si usas saveOrUpdate en la interfaz
    @Transactional
    public Paciente saveOrUpdate(Paciente paciente) { // Usamos el nombre de la interfaz
        if (paciente.getIdPaciente() == null || paciente.getIdPaciente() == 0) {
            HistoriaClinica historia = new HistoriaClinica();
            historia.setFechaApertura(LocalDate.now());
            historia.setPaciente(paciente);
            paciente.setHistoriaClinica(historia);

        }
        return dao.save(paciente);
    }

    @Override
    public void savePaciente(Paciente paciente) {
        saveOrUpdate(paciente);
    }


    @Override
    public void deletePaciente(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Paciente> searchByPaciente(String palabraClave) {
        if (palabraClave == null || palabraClave.trim().isEmpty()) {
            return dao.findAll();
        }

        // Normalizar espacios
        palabraClave = palabraClave.trim().replaceAll("\\s+", " ");
        String[] tokens = palabraClave.split(" ");

        // Usamos un Set para evitar duplicados
        Set<Paciente> resultados = new LinkedHashSet<>();

        for (String token : tokens) {
            resultados.addAll(
                    dao.findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrDniContainingIgnoreCase(
                            token, token, token
                    )
            );
        }

        return new ArrayList<>(resultados);
    }



    @Override
    public Paciente findByDni(String dni) {
        return dao.findByDni(dni);
    }


}
