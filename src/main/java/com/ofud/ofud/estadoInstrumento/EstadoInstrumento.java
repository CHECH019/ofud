package com.ofud.ofud.estadoInstrumento;

import java.util.Set;

import com.ofud.ofud.inventarioInstrumento.InventarioInstrumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTADOINSTRUMENTO")
public class EstadoInstrumento {

    @Id
    @Column(name = "ESTADOINSTRUMENTO", nullable = false, length = 3)
    private String estadoInstrumento;

    @Column(name = "DESCESTADOINSTRU", nullable = false, length = 15)
    private String descripcionEstado;

    @OneToMany(mappedBy = "estadoInstrumento")
    private Set<InventarioInstrumento> inventarioInstrumentos;

}
