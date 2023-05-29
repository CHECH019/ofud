package com.ofud.ofud.compositor;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioCompositorImpl implements ServicioCompositor{

    private final CompositorDAO dao;
    @Override
    public Compositor findCompositorById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Compositor> findAllCompositors() {
        return dao.findAll();
    }

    @Override
    public Compositor saveCompositor(Compositor c) {
        return dao.save(c);
    }
    
}
