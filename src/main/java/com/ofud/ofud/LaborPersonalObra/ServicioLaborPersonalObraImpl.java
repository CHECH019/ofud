package com.ofud.ofud.LaborPersonalObra;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioLaborPersonalObraImpl implements ServicioLaborPersonalObra {
    private final LaborPersonalObraDAO dao;
    @Override
    public LaborPersonalObra findLaborPersonalObraById(Integer id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<LaborPersonalObra> findAllLaborPersonalObras() {
        return dao.findAll();
    }

    @Override
    public LaborPersonalObra savLaborPersonalObra(LaborPersonalObra lpo) {
        return dao.save(lpo);
    }
    
}
