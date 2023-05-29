package com.ofud.ofud.gastoObra;

import java.util.List;

public interface ServicioGastoObra {
    public GastoObra findGastoObraById(GastoObraId id);
    public List<GastoObra> findAllGastoObras();
    public GastoObra saveGastoObra(GastoObra go);
}
