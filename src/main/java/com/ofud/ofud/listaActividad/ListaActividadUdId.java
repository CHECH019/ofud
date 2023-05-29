package com.ofud.ofud.listaActividad;

import java.io.Serializable;

import lombok.Data;

@Data
public class ListaActividadUdId implements Serializable {
    private int periodo;
    private String codActividad;
}
