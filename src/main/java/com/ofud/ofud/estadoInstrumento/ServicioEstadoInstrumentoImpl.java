package com.ofud.ofud.estadoInstrumento;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioEstadoInstrumentoImpl implements ServicioEstadoInstrumento {
    private final EstadoInstrumentoDAO dao;
    @Override
    public EstadoInstrumento findEstadoInstrumentoById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<EstadoInstrumento> findAllEstadoInstrumentos() {
        return dao.findAll();
    }

    @Override
    public EstadoInstrumento saveEstadoInstrumento(EstadoInstrumento ei) {
        return dao.save(ei);
    }
    
}
