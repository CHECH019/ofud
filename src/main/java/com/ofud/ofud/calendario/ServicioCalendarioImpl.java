package com.ofud.ofud.calendario;

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
    public List<Calendario> findAllCalendarios() {
        return dao.findAll();
    }

    @Override
    public Calendario saveCalendario(Calendario c) {
        return dao.save(c);
    }
    
}
