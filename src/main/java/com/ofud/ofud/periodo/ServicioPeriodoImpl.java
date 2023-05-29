package com.ofud.ofud.periodo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioPeriodoImpl implements ServicioPeriodo{
    private final PeriodoDAO dao;

    @Override
    public Periodo findPeriodoById(Integer id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Periodo> findAllPeriodos() {
        return dao.findAll();
    }

    @Override
    public Periodo savePeriodo(Periodo p) {
        return dao.save(p);
    }
}
