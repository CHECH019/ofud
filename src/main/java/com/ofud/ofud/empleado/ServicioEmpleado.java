package com.ofud.ofud.empleado;

import java.util.List;

public interface ServicioEmpleado {
    public Empleado findEmpleadoById(EmpleadoId id);
    public List<Empleado> findAllEmpleados();
    public Empleado saveEmpleado(Empleado e);
}
