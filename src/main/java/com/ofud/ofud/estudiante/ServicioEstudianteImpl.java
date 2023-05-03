package com.ofud.ofud.estudiante;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServicioEstudianteImpl implements ServicioEstudiante{
    private final EstudianteDAO dao;

    @Override
    public Estudiante findEstudianteById(Long id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Estudiante> findAllEstudiantes() {
        return dao.findAll();
    }

    @Override
    public Estudiante saveEstudiante(Estudiante e) {
        return dao.save(e);
    }

}
