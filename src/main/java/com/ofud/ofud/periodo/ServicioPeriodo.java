package com.ofud.ofud.periodo;

import java.util.List;

public interface ServicioPeriodo {
    public Periodo findPeriodoById(Integer id);
    public List<Periodo> findAllPeriodos();
    public Periodo savePeriodo(Periodo p);
}
