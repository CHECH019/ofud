package com.ofud.ofud.gastoObra;

import java.io.Serializable;

import com.ofud.ofud.listaGastoUd.ListaGastoUdId;

import lombok.Data;

@Data
public class GastoObraId implements Serializable{
    private Long consecutivo;
    private ListaGastoUdId listaGastoUD;
}
