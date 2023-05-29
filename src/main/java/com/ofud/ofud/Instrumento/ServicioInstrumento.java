package com.ofud.ofud.Instrumento;

import java.util.List;

public interface ServicioInstrumento {
    public Instrumento findInstrumentoById(String id);
    public List<Instrumento> findAllInstrumentos();
    public Instrumento savInstrumento(Instrumento i);
}
