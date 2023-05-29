package com.ofud.ofud.obraInstrumento;

import java.util.List;

public interface ServicioObraInstrumento {
    public ObraInstrumento findObraInstrumentoById(ObraInstrumentoId id);
    public List<ObraInstrumento> findAllObraInstrumentos();
    public ObraInstrumento saveObraInstrumento(ObraInstrumento oi);
}
