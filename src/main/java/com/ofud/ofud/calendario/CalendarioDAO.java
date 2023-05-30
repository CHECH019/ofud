package com.ofud.ofud.calendario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface CalendarioDAO extends JpaRepository<Calendario,CalendarioId>{
    @Query(value = "SELECT c.consecalendario consec, o.idobra, t.idtipocalen, o.titulo, t.desctipocalendario AS tipoCal," +
    " to_char(c.fechainicio,'DD-MON-YY HH24:MI:SS') as fechaInicio,"+
    " to_char(c.fechafin,'DD-MON-YY HH24:MI:SS') as fechaFin,"+
    " c.idestadofkc AS estado from calendario c, tipocalendario t,"+
    " obra o where t.idtipocalen=c.idtipocalenfkc and c.idobrafkca = o.idobra"+
    " order by fechaInicio", nativeQuery= true)
    List<String[]> findAllCalendarios();

    @Modifying
    @Transactional
    @Query(value ="update calendario set idestadofkc='inactivo'"+
    " where consecalendario=?1 and idobrafkca=?2 and idtipocalenfkc = ?3", nativeQuery= true)
    void terminarCalendario(Integer consec, String idObra, String idTipo);

    
}
