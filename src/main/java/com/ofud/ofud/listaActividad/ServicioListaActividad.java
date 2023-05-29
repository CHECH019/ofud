package com.ofud.ofud.listaActividad;

import java.util.List;

public interface ServicioListaActividad {
    public ListaActividadUD findListaActividadUDById(ListaActividadUdId id);
    public List<ListaActividadUD> findAllListaActividadUDs();
    public ListaActividadUD saveListaActividadUD(ListaActividadUD la);
}
