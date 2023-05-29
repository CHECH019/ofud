package com.ofud.ofud.tipoUnidad;

import java.util.List;

public interface ServicioTipoUnidad {
    public TipoUnidad findTipoUnidadById(String id);
    public List<TipoUnidad> findAllTipoUnidads();
    public TipoUnidad saveTipoUnidad(TipoUnidad tu);
}
