package com.ofud.ofud.obraInstrumento;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ObraInstrumentoId implements Serializable{
    @Column(name = "CONSEC2", nullable = false)
    private int consecutivo;

    private String obra;
}
