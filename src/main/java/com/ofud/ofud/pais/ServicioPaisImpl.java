package com.ofud.ofud.pais;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioPaisImpl implements ServicioPais{
    private final PaisDAO dao;

    @Override
    public Pais findPaisById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Pais> findAllPais() {
        return dao.findAll();
    }

    @Override
    public Pais savePais(Pais p) {
        return dao.save(p);
    }
}
