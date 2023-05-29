package com.ofud.ofud.periodo;

import java.util.Set;

import com.ofud.ofud.listaActividad.ListaActividadUD;
import com.ofud.ofud.listaGastoUd.ListaGastoUD;
import com.ofud.ofud.obra.Obra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PERIODO")
@Data
public class Periodo {
    @Id
    @Column(name = "IDPERIODO", nullable = false, length = 7)
    private int id;

    @OneToMany(mappedBy = "periodo")
    private Set<Obra> obras;

    @OneToMany(mappedBy = "periodo")
    private Set<ListaActividadUD> listaActividades;

    @OneToMany(mappedBy = "periodo")
    private Set<ListaGastoUD> listaGastos;
}