package com.ofud.ofud.listaGastoUd;

import java.util.Set;

import com.ofud.ofud.gastoObra.GastoObra;
import com.ofud.ofud.periodo.Periodo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "LISTAGASTOUD")
@Data
@IdClass(ListaGastoUdId.class)
public class ListaGastoUD {

    @Id
    @ManyToOne
    @JoinColumn(name = "IDPERIODOFKL", nullable = false)
    private Periodo periodo;

    @Id
    @Column(name = "CODGASTOFK", nullable = false, length = 5)
    private String codGasto;

    @OneToMany(mappedBy = "listaGastoUD")
    private Set<GastoObra> gastoObras;

}
