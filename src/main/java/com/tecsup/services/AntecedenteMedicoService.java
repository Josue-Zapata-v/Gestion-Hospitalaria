package com.tecsup.services;

import com.tecsup.model.entities.AntecedenteMedico;
import java.util.List;

public interface AntecedenteMedicoService {

    // Listar todos los antecedentes médicos
    List<AntecedenteMedico> findAllAntecedentes();

    // Buscar antecedente por ID
    AntecedenteMedico findByIdAntecedente(int id);

    // Guardar o actualizar antecedente médico
    void saveAntecedente(AntecedenteMedico antecedenteMedico);

    // Eliminar antecedente médico
    void deleteAntecedente(int id);

    // Buscar antecedentes por historia clínica
    List<AntecedenteMedico> findByHistoriaClinicaId(int idHistoria);
}
