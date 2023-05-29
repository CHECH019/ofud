package com.ofud.ofud.inventarioInstrumento;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioInventarioInstrumentoImpl implements ServicioInventarioInstrumento{
    private final InventarioInstrumentoDAO dao;
    public InventarioInstrumento findInventarioInstrumentoById(Integer id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<InventarioInstrumento> findAllInventarioInstrumentos() {
        return dao.findAll();
    }

    @Override
    public InventarioInstrumento saveInventarioInstrumento(InventarioInstrumento ii) {
        return dao.save(ii);
    }
    
}
