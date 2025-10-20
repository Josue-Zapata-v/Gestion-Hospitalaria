package com.tecsup.services;

import com.tecsup.model.entities.HistoriaClinica;
import java.util.List;

public interface HistoriaClinicaService {

    // Listar todas las historias clínicas
    List<HistoriaClinica> findAllHistorias();

    // Buscar historia clínica por ID
    HistoriaClinica findByIdHistoria(int id);

    // Guardar o actualizar historia clínica
    void saveHistoria(HistoriaClinica historiaClinica);

    // Eliminar historia clínica
    void deleteHistoria(int id);

    // Buscar historia clínica por ID de paciente
    HistoriaClinica findByPacienteId(int idPaciente);
}
