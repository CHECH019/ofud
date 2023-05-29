package com.ofud.ofud.tipoUnidad;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioTipoUnidadImpl implements ServicioTipoUnidad{
    private final TipoUnidadDAO dao;

    @Override
    public TipoUnidad findTipoUnidadById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<TipoUnidad> findAllTipoUnidads() {
        return dao.findAll();
    }

    @Override
    public TipoUnidad saveTipoUnidad(TipoUnidad tu) {
        return dao.save(tu);
    }

}
