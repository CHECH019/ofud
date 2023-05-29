package com.ofud.ofud.LaborPersonalObra;

import com.ofud.ofud.PersonalObra.PersonalObra;
import com.ofud.ofud.calendario.Calendario;
import com.ofud.ofud.listaActividad.ListaActividadUD;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "LABORPERSONALOBRA")
@Data
public class LaborPersonalObra {

    @Id
    @Column(name = "CONSECLABOR", nullable = false)
    private int conseLabor;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "IDPERIODOFKLP", nullable = false),
        @JoinColumn(name = "CODACTIVIDADFKL", nullable = false)
    })
    private ListaActividadUD listaActividadUD;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "CODUNIDADFKEM"),
        @JoinColumn(name = "ROLFKP"),
        @JoinColumn(name = "ICODEMPLEADOFKL"),
        @JoinColumn(name = "IDPERSONALOBRAFKLP")
    })
    private PersonalObra personalObra;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "IDOBRAFKCA"),
        @JoinColumn(name = "IDTIPOCALENFKLP"),
        @JoinColumn(name = "CONSECALENDARIOFKL")
    })
    private Calendario calendario;

    @Column(name = "N_HORAS", nullable = false)
    private int nHoras;

}