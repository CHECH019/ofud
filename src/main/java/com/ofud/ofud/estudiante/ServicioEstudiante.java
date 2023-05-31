package com.ofud.ofud.estudiante;

import java.util.List;
import java.util.Map;

public interface ServicioEstudiante {
    public Estudiante findEstudianteById(String id);
    public List<Estudiante> findAllEstudiantes();
    public Estudiante saveEstudiante(Estudiante e);
    public List<EstudianteDTO> seleccionarEstudiantes();
    public void saveSeleccionado(String codEstudiante);
    public List<EstudianteDTO> findSeleccionados();
    public void marcarAsistencia(String idObra, String consec, List<String> codsEstudiante);
    
    public void sendMailElectivas();
    public Map<String,String> generarListaHorasTotales();
}