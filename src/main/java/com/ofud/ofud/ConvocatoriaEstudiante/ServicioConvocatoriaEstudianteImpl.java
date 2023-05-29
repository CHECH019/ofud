package com.ofud.ofud.ConvocatoriaEstudiante;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioConvocatoriaEstudianteImpl implements ServicioConvocatoriaEstudiante{
    private final ConvocatoriaEstudianteDAO dao;
    
    @Override
    public ConvocatoriaEstudiante findConvocatoriaEstudianteById(ConvocatoriaEstudianteId id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<ConvocatoriaEstudiante> findAllConvocatoriaEstudiantes() {
        return dao.findAll();
    }

    @Override
    public ConvocatoriaEstudiante saveConvocatoriaEstudiante(ConvocatoriaEstudiante c) {
        return dao.save(c);
    }
    
}