package com.ofud.ofud.ConvocatoriaEstudiante;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ConvocatoriaEstudianteId implements Serializable{
    @Column(name = "CONSECA", nullable = false)
    private int consecutivoA;

    private String obra;
}
