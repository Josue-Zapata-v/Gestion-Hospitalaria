package com.tecsup.model.daos;

import com.tecsup.model.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    // Buscar pacientes por nombre, apellido o DNI (ignorando mayúsculas)
    List<Paciente> findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrDniContainingIgnoreCase(
            String nombres, String apellidos, String dni
    );

    // Buscar paciente por DNI exacto
    Paciente findByDni(String dni);
}

