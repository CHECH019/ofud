package com.ofud.ofud.PersonalObra;

import java.util.List;

public interface ServicioPersonalObra {
    public PersonalObra findPersonalObraById(PersonalObraId id);
    public List<PersonalObra> findAllPersonalObras();
    public PersonalObra savePersonalObra(PersonalObra po);
}
