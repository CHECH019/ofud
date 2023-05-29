package com.ofud.ofud.PersonalObra;

import java.time.LocalDate;
import java.util.Set;

import com.ofud.ofud.LaborPersonalObra.LaborPersonalObra;
import com.ofud.ofud.empleado.Empleado;
import com.ofud.ofud.obra.Obra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PERSONALOBRA")
@Data
@IdClass(PersonalObraId.class)
public class PersonalObra {
    @Id
    @Column(name = "IDPERSONALOBRA", nullable = false)
    private int idPersonalObra;

    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ICODEMPLEADOFKP", nullable = false),
        @JoinColumn(name = "CODUNIDADFKEM", nullable = false),
        @JoinColumn(name = "ROLFKP", nullable = false)
    })
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "IDOBRAFKP", nullable = false)
    private Obra obra;

    @Column(name = "FECHAINICIO", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "FECHAFIN")
    private LocalDate fechaFin;

    @OneToMany(mappedBy = "personalObra")
    private Set<LaborPersonalObra> laborPersonalObras;

}
