package com.ofud.ofud.calendario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioCalendarioImpl implements ServicioCalendario{
    private final CalendarioDAO dao;
    @Override
    public Calendario findCalendarioById(CalendarioId id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<CalendarioDTO> findAllCalendarios() {
        List<CalendarioDTO> calendarios = new ArrayList<>();
        dao.findAllCalendarios().forEach(
            t-> calendarios.add(
                new CalendarioDTO(t[0],t[1],t[2],t[3],t[4])));
        return calendarios;
    }

    @Override
    public Calendario saveCalendario(Calendario c) {
        return dao.save(c);
    }
    
}
