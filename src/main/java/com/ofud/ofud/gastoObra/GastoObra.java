package com.ofud.ofud.gastoObra;

import java.time.LocalDate;

import com.ofud.ofud.listaGastoUd.ListaGastoUD;
import com.ofud.ofud.obra.Obra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "GASTOOBRA")
@Data
@IdClass(GastoObraId.class)
public class GastoObra {
    @Id
    @Column(name = "CONSEC", nullable = false)
    private Long consecutivo;

    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "IDPERIODO", nullable = false),
        @JoinColumn(name = "CODGASTO", nullable = false)
    })
    private ListaGastoUD listaGastoUD;

    @ManyToOne
    @JoinColumn(name = "IDOBRAFKG", nullable = false)
    private Obra obra;

    @Column(name = "FECHAGASTO", nullable = false)
    private LocalDate fechaGasto;
}
