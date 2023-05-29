package com.ofud.ofud.participacionEstudiante;

import java.util.List;

public interface ServicioParticipacionEstudiante {
    public ParticipacionEstudiante findParticipacionEstudianteById(Integer id);
    public List<ParticipacionEstudiante> findAllParticipacionEstudiantes();
    public ParticipacionEstudiante saveParticipacionEstudiante(ParticipacionEstudiante pe);
}
