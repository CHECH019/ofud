package com.ofud.ofud.LaborPersonalObra;

import java.util.List;

public interface ServicioLaborPersonalObra {
    public LaborPersonalObra findLaborPersonalObraById(Integer id);
    public List<LaborPersonalObra> findAllLaborPersonalObras();
    public LaborPersonalObra savLaborPersonalObra(LaborPersonalObra lpo);
}
