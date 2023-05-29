package com.ofud.ofud.estado;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioEstadoImpl implements ServicioEstado{

    private final EstadoDAO dao;

    @Override
    public Estado findEstadoById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Estado> findAllEstados() {
        return dao.findAll();
    }

    @Override
    public Estado saveEstado(Estado e) {
        return dao.save(e);
    }
    
}