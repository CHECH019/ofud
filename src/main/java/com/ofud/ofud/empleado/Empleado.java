package com.ofud.ofud.empleado;

import java.util.Set;

import com.ofud.ofud.PersonalObra.PersonalObra;
import com.ofud.ofud.rol.Rol;
import com.ofud.ofud.unidad.Unidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "EMPLEADO")
@Data
@IdClass(EmpleadoId.class)
public class Empleado {
    @Id
    @Column(name = "ICODEMPLEADO", nullable = false, length = 4)
    private String cod;

    @Id
    @ManyToOne
    @JoinColumn(name = "CODUNIDADFKEM", nullable = false)
    private Unidad unidad;

    @Id
    @ManyToOne
    @JoinColumn(name = "ROLFKE", nullable = false)
    private Rol rol;

    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 30)
    private String apellido;

    @Column(name = "CEDULA", nullable = false, length = 15)
    private String cedula;

    @Column(name = "CORREO", nullable = false, length = 40)
    private String correo;

    @Column(name = "CELULAR", nullable = false, length = 10)
    private String celular;

    @OneToMany(mappedBy = "empleado")
    private Set<PersonalObra> personalObras;

}
