package com.ofud.ofud.calendario;

import java.util.List;

public interface ServicioCalendario {
    public Calendario findCalendarioById(CalendarioId id);
    public List<CalendarioDTO> findAllCalendarios();
    public Calendario saveCalendario(Calendario c);
    public void terminarCalendario(Integer consec, String idObra, String idTipo);
}
