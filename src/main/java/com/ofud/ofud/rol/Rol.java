package com.ofud.ofud.rol;

import java.util.Set;

import com.ofud.ofud.empleado.Empleado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ROL")
@Data
public class Rol {

    @Id
    @Column(name = "ROL", nullable = false)
    private int rol;

    @Column(name = "DESCROL", nullable = false, length = 15)
    private String descripcion;

    @OneToMany(mappedBy = "rol")
    private Set<Empleado> empleados;

}