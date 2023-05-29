package com.ofud.ofud.obraInstrumento;

import com.ofud.ofud.Instrumento.Instrumento;
import com.ofud.ofud.obra.Obra;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "OBRAINSTRUMENTO")
@Data
public class ObraInstrumento {

    @EmbeddedId
    private ObraInstrumentoId obraInstrumentoId;

    @MapsId("obra")
    @ManyToOne
    @JoinColumn(name = "IDOBRAFKOI", nullable = false)
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "IDINSTRUMENTOFKOI", nullable = false)
    private Instrumento instrumento;

}