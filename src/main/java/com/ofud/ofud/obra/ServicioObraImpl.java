package com.ofud.ofud.obra;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioObraImpl implements ServicioObra{
    private final ObraDAO dao;

    @Override
    public Obra findObraById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Obra> findAllObras() {
        return dao.findAll();
    }

    @Override
    public Obra saveObra(Obra o) {
        return dao.save(o);
    }
}
