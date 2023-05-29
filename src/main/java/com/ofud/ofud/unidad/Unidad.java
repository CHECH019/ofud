package com.ofud.ofud.unidad;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofud.ofud.estudiante.Estudiante;
import com.ofud.ofud.tipoUnidad.TipoUnidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "UNIDAD")
@Data
public class Unidad {

    @Id
    @Column(name = "CODUNIDAD", nullable = false, length = 5)
    private String codUnidad;

    @ManyToOne
    @JoinColumn(name = "UNI_CODUNIDAD")
    private Unidad uniCodUnidad;

    @ManyToOne
    @JoinColumn(name = "TIPOUNIDADFKU", nullable = false)
    private TipoUnidad tipoUnidad;

    @Column(name = "NOMUNIDAD", nullable = false, length = 40)
    private String nomUnidad;

    @JsonIgnore
    @OneToMany(mappedBy = "uniCodUnidad")
    private Set<Unidad> unidades;

    @JsonIgnore
    @OneToMany(mappedBy = "unidad")
    private Set<Estudiante> estudiantes;
}