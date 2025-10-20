package com.tecsup.services;

import com.tecsup.model.entities.Paciente;
import java.util.List;

public interface PacienteService {

    // Listar todos los pacientes
    List<Paciente> findAllPacientes();

    // Buscar paciente por ID
    Paciente findByIdPaciente(int id);

    // Guardar o actualizar paciente
    void savePaciente(Paciente paciente);

    // Eliminar paciente
    void deletePaciente(int id);

    // Buscar por nombre o apellido
    List<Paciente> searchByPaciente(String palabraClave);

    // Buscar por DNI
    Paciente findByDni(String dni);
    Paciente saveOrUpdate(Paciente paciente); // 💡 Añadir este método
}
