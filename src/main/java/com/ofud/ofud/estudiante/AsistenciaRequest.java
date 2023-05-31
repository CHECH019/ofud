package com.ofud.ofud.estudiante;

import java.util.List;

public record AsistenciaRequest(
    String idObra, 
    String consec, 
    List<String> codsEstudiante) {}
