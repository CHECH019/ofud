package com.ofud.ofud.empleado;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioEmpleadoImpl implements ServicioEmpleado {
    private final EmpleadoDAO dao;
    @Override
    public Empleado findEmpleadoById(EmpleadoId id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Empleado> findAllEmpleados() {
        return dao.findAll();
    }

    @Override
    public Empleado saveEmpleado(Empleado e) {
        return dao.save(e);
    }

    @Override
    public String findCoorGeneral(Map<String,String> email) {
        List<String> coord = dao.findCoordGeneral();
        
        String mail = email.get("email");
        if(coord.contains(mail)){
            String name = dao.findNombreAndApellidoByCorreo(mail);
            return name;
        }
        return "Denegado";
    }
    
}
