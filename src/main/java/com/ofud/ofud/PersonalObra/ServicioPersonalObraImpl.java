package com.ofud.ofud.PersonalObra;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioPersonalObraImpl implements ServicioPersonalObra{
    private final PersonalObraDAO dao;

    @Override
    public PersonalObra findPersonalObraById(PersonalObraId id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<PersonalObra> findAllPersonalObras() {
        return dao.findAll();
    }

    @Override
    public PersonalObra savePersonalObra(PersonalObra po) {
        return dao.save(po);
    }
}
