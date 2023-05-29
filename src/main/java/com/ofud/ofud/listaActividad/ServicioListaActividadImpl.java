package com.ofud.ofud.listaActividad;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioListaActividadImpl implements ServicioListaActividad{
    private final ListaActividadDAO dao;
    @Override
    public ListaActividadUD findListaActividadUDById(ListaActividadUdId id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<ListaActividadUD> findAllListaActividadUDs() {
        return dao.findAll();
    }

    @Override
    public ListaActividadUD saveListaActividadUD(ListaActividadUD la) {
        return dao.save(la);
    }
    
}
