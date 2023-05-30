package com.ofud.ofud.calendario;

public record CalendarioDTO(
    int consec,
    String idObra,
    String idTipoCal,
    String titulo, 
    String tipoCal, 
    String fechaInicio, 
    String fechaFin, 
    String estado) {
}
