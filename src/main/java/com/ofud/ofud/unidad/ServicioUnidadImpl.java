package com.ofud.ofud.unidad;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioUnidadImpl implements ServicioUnidad{
    private final UnidadDAO dao;

    @Override
    public Unidad findUnidadById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Unidad> findAllUnidads() {
        return dao.findAll();
    }

    @Override
    public Unidad saveUnidad(Unidad u) {
        return dao.save(u);
    }
}
