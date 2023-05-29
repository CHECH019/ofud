package com.ofud.ofud.gastoObra;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioGastoObraImpl implements ServicioGastoObra{

    private final GastoObraDAO dao;

    @Override
    public GastoObra findGastoObraById(GastoObraId id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<GastoObra> findAllGastoObras() {
        return dao.findAll();
    }

    @Override
    public GastoObra saveGastoObra(GastoObra go) {
        return dao.save(go);
    }
    
}
