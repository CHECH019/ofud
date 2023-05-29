package com.ofud.ofud.ConvocatoriaEstudiante;

import java.util.List;

public interface ServicioConvocatoriaEstudiante {
    public ConvocatoriaEstudiante findConvocatoriaEstudianteById(ConvocatoriaEstudianteId id);
    public List<ConvocatoriaEstudiante> findAllConvocatoriaEstudiantes();
    public ConvocatoriaEstudiante saveConvocatoriaEstudiante(ConvocatoriaEstudiante c);
}
