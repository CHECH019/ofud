package com.ofud.ofud.estudiante;

import java.util.List;

public interface ServicioEstudiante {
    public Estudiante findEstudianteById(Long id);
    public List<Estudiante> findAllEstudiantes();
    public Estudiante saveEstudiante(Estudiante e);
    
}
