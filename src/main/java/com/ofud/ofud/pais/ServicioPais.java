package com.ofud.ofud.pais;

import java.util.List;

public interface ServicioPais {
    public Pais findPaisById(String id);
    public List<Pais> findAllPais();
    public Pais savePais(Pais p);
}
