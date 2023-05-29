package com.ofud.ofud.participacionEstudiante;

import com.ofud.ofud.calendario.Calendario;
import com.ofud.ofud.estudiante.Estudiante;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PARTICIPACIONESTUDIANTE")
@Data
public class ParticipacionEstudiante {

    @Id
    @Column(name = "CONSECASIS", nullable = false)
    private int consecutivoAsis;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "CONSECALENDARIOFKP", nullable = false),
        @JoinColumn(name = "IDTIPOCALENFKPE", nullable = false),
        @JoinColumn(name = "IDOBRAFKCA", nullable = false)
        
    })
    private Calendario calendario;

    @ManyToOne
    @JoinColumn(name = "CODESTUDIANTEFKP", nullable = false)
    private Estudiante estudiante;

}