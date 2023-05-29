package com.ofud.ofud.inventarioInstrumento;

import java.time.LocalDate;

import com.ofud.ofud.Instrumento.Instrumento;
import com.ofud.ofud.estadoInstrumento.EstadoInstrumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "INVENTORIOINSTRUMENTO")
@Data
public class InventarioInstrumento {

    @Id
    @Column(name = "CONSECINVENTARIO", nullable = false)
    private int consecutivoInventario;

    @ManyToOne
    @JoinColumn(name = "IDINSTRUMENTOFKI", nullable = false)
    private Instrumento instrumento;

    @ManyToOne
    @JoinColumn(name = "ESTADOINSTRUMENTOFKI", nullable = false)
    private EstadoInstrumento estadoInstrumento;

    @Column(name = "FECHAINGRESO", nullable = false)
    private LocalDate fechaIngreso;

}