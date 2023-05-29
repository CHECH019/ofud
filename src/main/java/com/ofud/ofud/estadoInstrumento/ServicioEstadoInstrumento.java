package com.ofud.ofud.estadoInstrumento;

import java.util.List;

public interface ServicioEstadoInstrumento {
    public EstadoInstrumento findEstadoInstrumentoById(String id);
    public List<EstadoInstrumento> findAllEstadoInstrumentos();
    public EstadoInstrumento saveEstadoInstrumento(EstadoInstrumento ei);
}
