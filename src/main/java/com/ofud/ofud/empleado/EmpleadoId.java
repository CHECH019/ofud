package com.ofud.ofud.empleado;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmpleadoId implements Serializable{
    private String cod;
    private String unidad;
    private int rol;
}
