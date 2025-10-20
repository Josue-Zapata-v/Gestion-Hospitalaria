package com.tecsup.controller;

import com.tecsup.model.entities.AntecedenteMedico;
import com.tecsup.model.entities.HistoriaClinica;
import com.tecsup.model.entities.Paciente;
import com.tecsup.services.PacienteService;
import com.tecsup.services.HistoriaClinicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.tecsup.services.AntecedenteMedicoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestHeader;


import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private HistoriaClinicaService historiaClinicaService;
    @Autowired
    private AntecedenteMedicoService antecedenteMedicoService;

    // 🟢 LISTAR PACIENTES
    @GetMapping("/listar")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.findAllPacientes();
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("titulo", "Listado de Pacientes");
        return "pacientes/listar"; // Vista: templates/pacientes/listar.html
    }

    // 🟢 FORMULARIO DE NUEVO PACIENTE
    @GetMapping("/nuevo")
    public String nuevoPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        model.addAttribute("titulo", "Registrar Nuevo Paciente");
        return "pacientes/form"; // Vista: templates/pacientes/form.html
    }

    // 🟢 GUARDAR PACIENTE (nuevo o editado)
    // PacienteController.java

    @PostMapping("/guardar")
    public String guardarPaciente(@Valid @ModelAttribute Paciente paciente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // ...
            return "pacientes/form";
        }
        pacienteService.saveOrUpdate(paciente);
        return "redirect:/pacientes/listar";
    }

    // 🟢 EDITAR PACIENTE
    @GetMapping("/editar/{id}")
    public String editarPaciente(@PathVariable("id") int id, Model model) {
        Paciente paciente = pacienteService.findByIdPaciente(id);
        if (paciente == null) {
            return "redirect:/pacientes/listar";
        }
        model.addAttribute("paciente", paciente);
        model.addAttribute("titulo", "Editar Paciente");
        return "pacientes/form";
    }

    // 🟢 ELIMINAR PACIENTE
    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable("id") int id) {
        pacienteService.deletePaciente(id);
        return "redirect:/pacientes/listar";
    }

    // 🟢 BUSCAR PACIENTE POR NOMBRE O APELLIDO
    @GetMapping("/buscar")
    public String buscar(@RequestParam("q") String palabraClave, Model model) {
        if (palabraClave == null) palabraClave = "";
        // Quitar espacios al inicio/fin
        palabraClave = palabraClave.trim();

        List<Paciente> pacientes = pacienteService.searchByPaciente(palabraClave);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("titulo", "Resultados de búsqueda");
        model.addAttribute("q", palabraClave);
        return "pacientes/listar";
    }


    @GetMapping("/detalle/{id}")
    public String detallePaciente(@PathVariable int id, Model model) {
        Paciente paciente = pacienteService.findByIdPaciente(id);
        HistoriaClinica historia = paciente.getHistoriaClinica();
        model.addAttribute("paciente", paciente);
        model.addAttribute("historia", historia);
        return "pacientes/detalle";
    }

    // Mostrar formulario para nuevo antecedente
    @GetMapping("/{idPaciente}/antecedentes/nuevo")
    public String nuevoAntecedente(@PathVariable int idPaciente, Model model) {
        AntecedenteMedico antecedente = new AntecedenteMedico();
        Paciente paciente = pacienteService.findByIdPaciente(idPaciente);
        antecedente.setHistoriaClinica(paciente.getHistoriaClinica());

        model.addAttribute("antecedente", antecedente);
        model.addAttribute("paciente", paciente);
        model.addAttribute("titulo", "Agregar Antecedente Médico");
        return "pacientes/antecedentes/antecedente_form";
    }

    // Guardar antecedente
    @PostMapping("/{idPaciente}/antecedentes/guardar")
    public String guardarAntecedente(@PathVariable int idPaciente, @ModelAttribute AntecedenteMedico antecedente) {
        antecedenteMedicoService.saveAntecedente(antecedente);
        return "redirect:/pacientes/listar";
    }

    @GetMapping("/{idPaciente}/antecedentes/editar/{idAntecedente}")
    public String editarAntecedente(@PathVariable int idPaciente, @PathVariable int idAntecedente, Model model) {
        AntecedenteMedico antecedente = antecedenteMedicoService.findByIdAntecedente(idAntecedente);
        model.addAttribute("antecedente", antecedente);
        model.addAttribute("paciente", pacienteService.findByIdPaciente(idPaciente));
        model.addAttribute("titulo", "Editar Antecedente Médico");
        return "pacientes/antecedentes/antecedente_form";
    }


    @GetMapping("/{idPaciente}/antecedentes/eliminar/{idAntecedente}")
    public String eliminarAntecedente(@PathVariable int idPaciente, @PathVariable int idAntecedente) {
        antecedenteMedicoService.deleteAntecedente(idAntecedente);
        return "redirect:/pacientes/listar";
    }



}
