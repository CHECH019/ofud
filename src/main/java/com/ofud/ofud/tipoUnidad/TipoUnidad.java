package com.ofud.ofud.tipoUnidad;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofud.ofud.unidad.Unidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TIPOUNIDAD")
@Data
public class TipoUnidad {

    @Id
    @Column(name = "TIPOUNIDAD", nullable = false, length = 2)
    private String tipoUnidad;

    @Column(name = "DESCTIPOUNI", nullable = false, length = 20)
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoUnidad")
    private Set<Unidad> unidades;

}