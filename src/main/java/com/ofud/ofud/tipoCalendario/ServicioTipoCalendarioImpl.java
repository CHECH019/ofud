package com.ofud.ofud.tipoCalendario;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioTipoCalendarioImpl implements ServicioTipoCalendario{
    private final TipoCalendarioDAO dao;

    @Override
    public TipoCalendario findTipoCalendarioById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<TipoCalendario> findAllTipoCalendarios() {
        return dao.findAll();
    }

    @Override
    public TipoCalendario saveTipoCalendario(TipoCalendario tc) {
        return dao.save(tc);
    }
}
