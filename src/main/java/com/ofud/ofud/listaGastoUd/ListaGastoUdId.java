package com.ofud.ofud.listaGastoUd;

import java.io.Serializable;

import lombok.Data;

@Data
public class ListaGastoUdId implements Serializable {
    private int periodo;
    private String codGasto;
}
