package com.ofud.ofud.calendario;

import java.util.List;
import java.util.Map;

public interface ServicioCalendario {
    public Calendario findCalendarioById(CalendarioId id);
    public List<CalendarioDTO> findAllCalendarios();
    public Calendario saveCalendario(Calendario c);
    public void terminarCalendario(Integer consec, String idObra, String idTipo);
    public Map<String,Boolean> checkState();
    public Map<String, Boolean> estadoPlaneacion();
    public Map<String,String> findEnsayoByDate(String date);
}
