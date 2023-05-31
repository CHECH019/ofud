package com.ofud.ofud.estudiante;

import java.util.List;

public interface ServicioEstudiante {
    public Estudiante findEstudianteById(String id);
    public List<Estudiante> findAllEstudiantes();
    public Estudiante saveEstudiante(Estudiante e);
    public List<EstudianteDTO> seleccionarEstudiantes();
    public void saveSeleccionado(String codEstudiante);
    public List<EstudianteDTO> findSeleccionados();
}