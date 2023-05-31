package com.ofud.ofud.calendario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioCalendarioImpl implements ServicioCalendario{
    private final CalendarioDAO dao;
    @Override
    public Calendario findCalendarioById(CalendarioId id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<CalendarioDTO> findAllCalendarios() {
        List<CalendarioDTO> calendarios = new ArrayList<>();
        dao.findAllCalendarios().forEach(
            t-> calendarios.add(
                new CalendarioDTO(
                    Integer.parseInt(t[0]),
                    t[1],t[2],t[3],t[4],t[5],t[6],t[7])));
        return calendarios;
    }

    @Override
    public Calendario saveCalendario(Calendario c) {
        return dao.save(c);
    }

    @Override
    public void terminarCalendario(Integer consec, String idObra, String idTipo) {
        dao.terminarCalendario(consec, idObra, idTipo);
    }

    @Override
    public Map<String, Boolean> checkState() {
        if(dao.actividadesPeriodoActual() == 0 || dao.estadoPlaneacion().equals("activo")){
            return Map.of("state", true);
        }
        return Map.of("state", false);
    }

    @Override
    public Map<String, Boolean> estadoPlaneacion(){
        if(dao.estadoPlaneacion().equals("inactivo")){
            return Map.of("state", true);
        }
        return Map.of("state", false);
    }

    @Override
    public Map<String, String> findEnsayoByDate(String date) {
        Map<String,String> ensayosMap = new HashMap<>();
        
        dao.findEnsayoByDate(date).forEach(
            t-> {
                ensayosMap.put("consec", t[0]);
                ensayosMap.put("idObra", t[1]);
                ensayosMap.put("idTipoCal", t[2]);
            }
        );
        return ensayosMap;
    }
    
}