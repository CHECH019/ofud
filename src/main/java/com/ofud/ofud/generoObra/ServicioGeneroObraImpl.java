package com.ofud.ofud.generoObra;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioGeneroObraImpl implements ServicioGeneroObra {
    private final GeneroObraDAO dao;

    @Override
    public GeneroObra findGeneroObraById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<GeneroObra> findAllGeneroObra() {
        return dao.findAll();
    }

    @Override
    public GeneroObra saveGeneroObra(GeneroObra go) {
        return dao.save(go);
    }
      
}