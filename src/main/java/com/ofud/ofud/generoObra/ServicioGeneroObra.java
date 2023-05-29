package com.ofud.ofud.generoObra;

import java.util.List;

public interface ServicioGeneroObra {
    public GeneroObra findGeneroObraById(String id);
    public List<GeneroObra> findAllGeneroObra();
    public GeneroObra saveGeneroObra(GeneroObra go);
}
