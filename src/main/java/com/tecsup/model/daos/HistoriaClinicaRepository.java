package com.tecsup.model.daos;

import com.tecsup.model.entities.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer> {

    // Buscar historia clínica por id de paciente
    HistoriaClinica findByPacienteIdPaciente(Integer idPaciente);
}
