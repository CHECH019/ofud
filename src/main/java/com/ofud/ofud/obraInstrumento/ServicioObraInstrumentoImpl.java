package com.ofud.ofud.obraInstrumento;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioObraInstrumentoImpl implements ServicioObraInstrumento{
    
    private final ObraInstrumentoDAO dao;

    @Override
    public ObraInstrumento findObraInstrumentoById(ObraInstrumentoId id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<ObraInstrumento> findAllObraInstrumentos() {
        return dao.findAll();
    }

    @Override
    public ObraInstrumento saveObraInstrumento(ObraInstrumento oi) {
        return dao.save(oi);
    }

}
