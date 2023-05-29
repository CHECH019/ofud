package com.ofud.ofud.unidad;

import java.util.List;

public interface ServicioUnidad {
    public Unidad findUnidadById(String id);
    public List<Unidad> findAllUnidads();
    public Unidad saveUnidad(Unidad u);
}
