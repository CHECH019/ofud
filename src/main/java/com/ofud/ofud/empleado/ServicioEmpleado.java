package com.ofud.ofud.empleado;

import java.util.List;
import java.util.Map;

public interface ServicioEmpleado {
    public Empleado findEmpleadoById(EmpleadoId id);
    public List<Empleado> findAllEmpleados();
    public Empleado saveEmpleado(Empleado e);
    public String findCoorGeneral(Map<String,String> email);
}
