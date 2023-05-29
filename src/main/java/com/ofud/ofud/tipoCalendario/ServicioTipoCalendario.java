package com.ofud.ofud.tipoCalendario;

import java.util.List;

public interface ServicioTipoCalendario {
    public TipoCalendario findTipoCalendarioById(String id);
    public List<TipoCalendario> findAllTipoCalendarios();
    public TipoCalendario saveTipoCalendario(TipoCalendario tc);
}
