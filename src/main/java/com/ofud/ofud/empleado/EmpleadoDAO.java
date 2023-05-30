package com.ofud.ofud.empleado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpleadoDAO extends JpaRepository<Empleado,EmpleadoId>{
    @Query(value = "select e.correo from empleado e, rol r where e.rolfke=r.rol and lower(r.descRol) like '%c.sinf%'",nativeQuery = true)
    List<String> findCoordGeneral();

    @Query("select distinct (e.nombre || ' ' || e.apellido) from Empleado e where e.correo = ?1")
    String findNombreAndApellidoByCorreo(String correo);
}
