package com.ofud.ofud.compositor;

import java.util.List;

public interface ServicioCompositor {
    public Compositor findCompositorById(String id);
    public List<Compositor> findAllCompositors();
    public Compositor saveCompositor(Compositor c);
}
