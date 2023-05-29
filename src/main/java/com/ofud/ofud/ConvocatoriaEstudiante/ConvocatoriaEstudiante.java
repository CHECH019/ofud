package com.ofud.ofud.ConvocatoriaEstudiante;

import java.time.LocalDate;

import com.ofud.ofud.Instrumento.Instrumento;
import com.ofud.ofud.estudiante.Estudiante;
import com.ofud.ofud.obra.Obra;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CONVOCATORIAESTUDIANTE")
@Data
public class ConvocatoriaEstudiante {
    
    @EmbeddedId
    private ConvocatoriaEstudianteId convocatoriaEstudianteId;

    @MapsId("obra")
    @ManyToOne
    @JoinColumn(name = "IDOBRAFKC", nullable = false)
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "CODESTUDIANTEFKC", nullable = false)
    private Estudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name = "IDINSTRUMENTOFKC", nullable = false)
    private Instrumento instrumento;

    @Column(name = "FECHAINICIO", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "FECHAFIN", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "CALIFICACION", nullable = false)
    private double calificacion;
}
