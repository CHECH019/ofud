package com.ofud.ofud.listaGastoUd;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioListaGastoImpl implements ServicioListaGasto{

    private final ListaGastoDAO dao;
    @Override
    public ListaGastoUD findListaGastoUDById(ListaGastoUdId id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<ListaGastoUD> findAllListaGastoUDs() {
        return dao.findAll();
    }

    @Override
    public ListaGastoUD saveListaGastoUD(ListaGastoUD lg) {
        return dao.save(lg);
    }
    
}
