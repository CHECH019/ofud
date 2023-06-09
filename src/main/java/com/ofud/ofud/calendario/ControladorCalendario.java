package com.ofud.ofud.calendario;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ofud/api/v1/calendarios")
public class ControladorCalendario{
    private final ServicioCalendario service;

    @GetMapping({"/",""})
    public List<CalendarioDTO> getCalendarios(){
        return service.findAllCalendarios();
    }

    @PutMapping("/terminar")
    public void terminarCalendario(@RequestParam int consec, @RequestParam String idObra, @RequestParam String idTipo){
        System.out.println(consec+" "+idObra+" "+idTipo);
        service.terminarCalendario(consec, idObra, idTipo);
    }

    @GetMapping("/validar")
    public Map<String,Boolean> validar(){
        return service.checkState();
    }

    @GetMapping("/estadoplaneacion")
    public Map<String,Boolean> estadoPlaneacion(){
        return service.estadoPlaneacion();
    }

    @GetMapping("/ensayo")
    public Map<String,String> ensayo(@RequestParam String date){        
        return service.findEnsayoByDate(date);
    }

    @GetMapping("/count")
    public Map<String,Integer> count(@RequestParam String date){        
        return service.calendariosDespuesDe(date);
    }
}