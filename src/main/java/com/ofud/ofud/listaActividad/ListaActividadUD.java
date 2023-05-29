package com.ofud.ofud.listaActividad;

import java.util.Set;

import com.ofud.ofud.LaborPersonalObra.LaborPersonalObra;
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
@Table(name = "LISTAACTIVIDADUD")
@Data
@IdClass(ListaActividadUdId.class)
public class ListaActividadUD {
    @Id
    @ManyToOne
    @JoinColumn(name = "IDPERIODOFKLA", nullable = false)
    private Periodo periodo;

    @Id
    @Column(name = "CODACTIVIDAD", nullable = false, length = 5)
    private String codActividad;

    @Column(name = "DESCACTIVIDAD", nullable = false, length = 40)
    private String descActividad;

    @Column(name = "VALORHORA", nullable = false)
    private Long valorHora;

    @Column(name = "MAXHORAS", nullable = false)
    private int maxHoras;

    @OneToMany(mappedBy = "listaActividadUD")
    private Set<LaborPersonalObra> laborPersonalObras;
}
