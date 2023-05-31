package com.ofud.ofud.estudiante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import jakarta.transaction.Transactional;

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
        "FROM convocatoriaestudiante ce, obra o "+
         "WHERE ce.idObraFKC = o.idObra "+
            "AND o.idPeriodoFKO = '202301' "+
           "AND ce.idinstrumentofkc IN ( "+
             "SELECT oi.idinstrumentofkoi "+
              "FROM obrainstrumento oi, obra o "+
             "WHERE o.idobra = oi.idobrafkoi "+
               "AND o.idperiodofko = '202301' "+
             "GROUP BY oi.idinstrumentofkoi "+
             "HAVING COUNT(oi.idinstrumentofkoi) > 1 ) "+
           "order by ce.calificacion) where rownum<2)", nativeQuery = true)
    List<String[]> seleccionEstudiantes();

    @Query("select o.idObra from Obra o where o.periodo.id = ?1")
    int findObraIdByPeriodo(String idPeriodo);

    @Query(value = "select consecalendario from calendario where idobrafkca=?1 and idTipoCalenFKC=3", nativeQuery = true)
    int findCalendarioByObra(String idObra);

    @Modifying
    @Transactional
    @Query(value = "insert into participacionestudiante(consecasis,idobrafkca,idTipoCalenFKpe,consecalendariofkp,codestudiantefkp)"+ 
    "values(PART_EST_SEQ.NEXTVAL,?1,3,?2,?3)", nativeQuery = true)
    void saveParticipacionEstudiante(String obraId, String consec, String idEstudiante);

    @Modifying
    @Transactional
    @Query(value="update calendario set idestadofkc='inactivo' where idtipocalenfkc=3 and idobrafkca=?1", nativeQuery = true)
    void setSeleccionInactiva(String idObra);

    @Query(value="SELECT distinct e.codestudiante AS codigo, e.nombre AS nombre, e.apellido AS apellido,"+
    " u.nomunidad AS proyecto, un.nomunidad AS facultad, i.nominstrumento AS instrumento "+
    "FROM estudiante e, unidad u, unidad un, instrumento i, convocatoriaestudiante ce "+
     "WHERE e.codunidadfke = u.codunidad "+
        "AND un.codunidad = u.uni_codunidad "+
        "and ce.idinstrumentofkc=i.idinstrumento "+
        "and ce.codestudiantefkc=e.codestudiante " +
         "AND e.codestudiante in "+
         "(select distinct pe.codestudiantefkp " +
         "from participacionestudiante pe, obra o" +
         " where pe.idtipocalenfkpe=3 and o.idobra=pe.idobrafkca and o.idperiodoFKo='202301')",nativeQuery = true)
    List<String[]> findSeleccionados();

    @Modifying
    @Transactional
    @Query(value = "insert into participacionestudiante"+
    "(consecasis,idobrafkca,idTipoCalenFKpe,consecalendariofkp,codestudiantefkp)"+ 
    " values(PART_EST_SEQ.NEXTVAL,?2,4,?3,?1)", nativeQuery = true)
    void asistencia(String codEstudiante, String idObra, String consec);

    @Query(value = "select e.codestudiante, e.nombre, e.apellido, sum(ROUND((fechafin - fechainicio) * 24))  horas_totales "+
    "from estudiante e, participacionestudiante pe, calendario c "+
    "where e.codestudiante=pe.codestudiantefkp and c.consecalendario=pe.consecalendariofkp "+
    "and pe.idtipocalenfkpe=c.idtipocalenfkc and c.idobrafkca=pe.idobrafkca "+
    "group by e.codestudiante,  e.nombre, e.apellido", nativeQuery = true)
    List<String[]> viaticos();

    @Modifying
    @Transactional
    @Query(value = "update calendario set idestadofkc='inactivo' where idtipocalenfkc=3 or idtipocalenfkc=4 or idtipocalenfkc=5 and idobrafkca=1", nativeQuery = true)
    void setCalendariosInactivos();

    @Query(value="SELECT e.codestudiante, e.nombre, e.apellido, u.nomunidad, "+
    "SUM(ROUND((fechafin - fechainicio) * 24)) AS horas_totales, "+
    "horas.horas_totales horas_necesarias, e.correo "+
    "FROM estudiante e, participacionestudiante pe, calendario c, unidad u, "+
    "(SELECT SUM(ROUND((fechafin - fechainicio) * 24)) AS horas_totales "+
    "FROM calendario c "+
    "WHERE c.idTipoCalenfkc = 4 OR c.idTipoCalenfkc = 5) horas "+
    "WHERE e.codestudiante = pe.codestudiantefkp "+
        "AND c.consecalendario = pe.consecalendariofkp "+
        "AND pe.idtipocalenfkpe = c.idtipocalenfkc "+
        "AND c.idobrafkca = pe.idobrafkca "+
        "AND u.codunidad=e.codunidadfke "+
    "GROUP BY e.codestudiante, e.nombre, e.apellido, horas.horas_totales, e.correo, u.nomunidad", nativeQuery = true)
    List<String[]> estudianteElectivas();

    @Query(value = "select distinct e.codestudiante, e.nombre, e.apellido, un.nomunidad facultad, e.correo "+
    "from estudiante e, unidad u, unidad un, participacionestudiante pe "+
    "where e.codestudiante=pe.codestudiantefkp and u.codunidad=un.uni_codunidad", nativeQuery = true)
    List<String[]> estudiantesCorreo();
}
