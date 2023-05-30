package com.ofud.ofud.estudiante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstudianteDAO extends JpaRepository<Estudiante,String>{
    
    @Query(value = "SELECT e.codestudiante AS codigo, e.nombre AS nombre,"+
    "e.apellido AS apellido, u.nomunidad AS proyecto, un.nomunidad AS facultad, "+
    "i.nominstrumento AS instrumento "+
    "FROM estudiante e, unidad u, unidad un, convocatoriaestudiante ce, "+ 
    "instrumento i, obra o "+
     "WHERE e.codunidadfke = u.codunidad "+
        "AND un.codunidad = u.uni_codunidad "+
         "AND ce.codestudiantefkc = e.codestudiante "+
         "AND i.idinstrumento = ce.idinstrumentofkc "+
         "AND ce.idobrafkc = o.idobra "+
         "AND o.idperiodofko = '202301' "+
         "AND ( "+
          "ce.calificacion, ce.idInstrumentoFKC " +
        ") IN ( "+
          "SELECT MAX(ce.calificacion), ce.idInstrumentoFKC "+
          "FROM convocatoriaestudiante ce, instrumento i, obra o "+
         "WHERE ce.idInstrumentoFKC = i.idInstrumento "+
            "AND ce.idObraFKC = o.idObra "+
           "AND o.idPeriodoFKO = '202301' "+
         "GROUP BY ce.idInstrumentofkc "+
        "UNION "+
        "select * from(SELECT ce.calificacion, ce.idInstrumentoFKC "+
        "FROM convocatoriaestudiante ce, instrumento i, obra o, obrainstrumento oi "+
         "WHERE ce.idInstrumentoFKC = i.idInstrumento "+
            "AND ce.idObraFKC = o.idObra "+
            "AND o.idPeriodoFKO = '202301' "+
           "AND ce.idinstrumentofkc IN ( "+
             "SELECT oi.idinstrumentofkoi "+
              "FROM obrainstrumento oi, obra o "+
             "WHERE o.idobra = oi.idobrafkoi "+
               "AND o.idperiodofko = '202301' "+
             "GROUP BY oi.idinstrumentofkoi "+
             "HAVING COUNT(oi.idinstrumentofkoi) > 1 "+
           ")) where rownum<=2)", nativeQuery = true)
    List<String[]> seleccionEstudiantes();
}
