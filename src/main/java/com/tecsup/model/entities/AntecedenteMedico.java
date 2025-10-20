package com.tecsup.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "antecedentes_medicos")
public class AntecedenteMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedente;

    @ManyToOne
    @JoinColumn(name = "id_historia", nullable = false)
    private HistoriaClinica historiaClinica;

    @Column(nullable = false, length = 100)
    private String tipo;

    @Column(name = "otro_tipo", length = 100)
    private String otroTipo;

    @Column(nullable = false, length = 500)
    private String descripcion;

    public AntecedenteMedico() {}

    // Getters y Setters
    public Long getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Long idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOtroTipo() {
        return otroTipo;
    }

    public void setOtroTipo(String otroTipo) {
        this.otroTipo = otroTipo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
