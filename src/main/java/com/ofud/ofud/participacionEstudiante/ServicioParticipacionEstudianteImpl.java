package com.ofud.ofud.participacionEstudiante;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioParticipacionEstudianteImpl implements ServicioParticipacionEstudiante{
    private final ParticipacionEstudianteDAO dao;

    @Override
    public ParticipacionEstudiante findParticipacionEstudianteById(Integer id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<ParticipacionEstudiante> findAllParticipacionEstudiantes() {
        return dao.findAll();
    }

    @Override
    public ParticipacionEstudiante saveParticipacionEstudiante(ParticipacionEstudiante pe) {
        return dao.save(pe);
    }
}
