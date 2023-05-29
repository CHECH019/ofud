package com.ofud.ofud.Instrumento;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioInstrumentoImpl implements ServicioInstrumento{

    private final InstrumentoDAO dao;
    @Override
    public Instrumento findInstrumentoById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Instrumento> findAllInstrumentos() {
        return dao.findAll();
    }

    @Override
    public Instrumento savInstrumento(Instrumento i) {
        return dao.save(i);
    }
    
}
