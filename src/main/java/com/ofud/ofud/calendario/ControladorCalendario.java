package com.ofud.ofud.calendario;

import java.util.List;

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
}