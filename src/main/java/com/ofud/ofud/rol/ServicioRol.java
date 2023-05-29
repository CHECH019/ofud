package com.ofud.ofud.rol;

import java.util.List;

public interface ServicioRol {
    public Rol findRolById(Integer id);
    public List<Rol> findAllRols();
    public Rol saveRol(Rol r);
}
