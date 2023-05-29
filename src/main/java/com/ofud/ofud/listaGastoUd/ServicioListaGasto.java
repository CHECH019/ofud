package com.ofud.ofud.listaGastoUd;

import java.util.List;

public interface ServicioListaGasto {
    public ListaGastoUD findListaGastoUDById(ListaGastoUdId id);
    public List<ListaGastoUD> findAllListaGastoUDs();
    public ListaGastoUD saveListaGastoUD(ListaGastoUD lg);
}
