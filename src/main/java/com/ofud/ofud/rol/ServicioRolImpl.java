package com.ofud.ofud.rol;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioRolImpl implements ServicioRol{
    private final RolDAO dao;

    @Override
    public Rol findRolById(Integer id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Rol> findAllRols() {
        return dao.findAll();
    }

    @Override
    public Rol saveRol(Rol r) {
        return dao.save(r);
    }
}
