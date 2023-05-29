package com.ofud.ofud.Instrumento;

import java.util.Set;

import com.ofud.ofud.ConvocatoriaEstudiante.ConvocatoriaEstudiante;
import com.ofud.ofud.inventarioInstrumento.InventarioInstrumento;
import com.ofud.ofud.obraInstrumento.ObraInstrumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "INSTRUMENTO")
public class Instrumento {

    @Id
    @Column(name = "IDINSTRUMENTO", nullable = false, length = 4)
    private String idInstrumento;

    @Column(name = "NOMINSTRUMENTO", nullable = false, length = 40)
    private String nombreInstrumento;

    @OneToMany(mappedBy = "instrumento")
    private Set<ObraInstrumento> obraInstrumentos;

    @OneToMany(mappedBy = "instrumento")
    private Set<InventarioInstrumento> inventarioInstrumentos;

    @OneToMany(mappedBy = "instrumento")
    private Set<ConvocatoriaEstudiante> convocatorias;

}