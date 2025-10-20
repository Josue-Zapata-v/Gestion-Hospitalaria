package com.tecsup.model.daos;

import com.tecsup.model.entities.AntecedenteMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AntecedenteMedicoRepository extends JpaRepository<AntecedenteMedico, Integer> {

    // Buscar antecedentes médicos por id de historia clínica
    List<AntecedenteMedico> findByHistoriaClinicaIdHistoria(Integer idHistoria);
}
