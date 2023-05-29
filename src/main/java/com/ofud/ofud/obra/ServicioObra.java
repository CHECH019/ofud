package com.ofud.ofud.obra;

import java.util.List;

public interface ServicioObra {
    public Obra findObraById(String id);
    public List<Obra> findAllObras();
    public Obra saveObra(Obra o);
}
