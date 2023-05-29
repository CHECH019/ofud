package com.ofud.ofud.estado;

import java.util.List;

public interface ServicioEstado {
    public Estado findEstadoById(String id);
    public List<Estado> findAllEstados();
    public Estado saveEstado(Estado e);
}
