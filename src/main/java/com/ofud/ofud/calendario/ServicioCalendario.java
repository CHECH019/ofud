package com.ofud.ofud.calendario;

import java.util.List;

public interface ServicioCalendario {
    public Calendario findCalendarioById(CalendarioId id);
    public List<Calendario> findAllCalendarios();
    public Calendario saveCalendario(Calendario c);
}
