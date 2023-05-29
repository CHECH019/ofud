package com.ofud.ofud.PersonalObra;

import java.io.Serializable;

import com.ofud.ofud.empleado.EmpleadoId;

import lombok.Data;

@Data
public class PersonalObraId implements Serializable{
    private int idPersonalObra;
    private EmpleadoId empleado;
}
