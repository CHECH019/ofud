package com.ofud.ofud.empleado;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ofud/api/v1/empleados")
public class ControladorEmpleado {
    private final ServicioEmpleado service;

    @PostMapping("/coord")
    public Map<String,String> getCoordGeneral(@RequestBody Map<String,String> email){
        return Map.of("Response", service.findCoorGeneral(email));
    }

}
