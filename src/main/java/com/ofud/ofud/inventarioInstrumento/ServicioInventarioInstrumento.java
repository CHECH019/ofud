package com.ofud.ofud.inventarioInstrumento;

import java.util.List;

public interface ServicioInventarioInstrumento {
    public InventarioInstrumento findInventarioInstrumentoById(Integer id);
    public List<InventarioInstrumento> findAllInventarioInstrumentos();
    public InventarioInstrumento saveInventarioInstrumento(InventarioInstrumento ii);
}
