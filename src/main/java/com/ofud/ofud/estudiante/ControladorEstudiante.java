package com.ofud.ofud.estudiante;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ofud/api/v1/estudiantes")
public class ControladorEstudiante {
    private final ServicioEstudiante service;

    @GetMapping("/welcome")
    public String greeting(){
        return "Welcome to OFUD!";
    }

    @GetMapping({"","/"})
    public List<Estudiante> getAllEstudiantes(){
        return service.findAllEstudiantes();
    }

    @PostMapping("/registro")
    public Estudiante registro(@RequestBody Estudiante e){
        return service.saveEstudiante(e);
    }
}
