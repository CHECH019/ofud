package com.ofud.ofud.obra;

import java.time.LocalDate;
import java.util.Set;

import com.ofud.ofud.ConvocatoriaEstudiante.ConvocatoriaEstudiante;
import com.ofud.ofud.PersonalObra.PersonalObra;
import com.ofud.ofud.calendario.Calendario;
import com.ofud.ofud.compositor.Compositor;
import com.ofud.ofud.gastoObra.GastoObra;
import com.ofud.ofud.generoObra.GeneroObra;
import com.ofud.ofud.obraInstrumento.ObraInstrumento;
import com.ofud.ofud.pais.Pais;
import com.ofud.ofud.periodo.Periodo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "OBRA")
@Data
public class Obra {
    @Id
    @Column(name = "IDOBRA", nullable = false, length = 4)
    private String idObra;

    @ManyToOne
    @JoinColumn(name = "IDCOMPOSITORFKO", nullable = false)
    private Compositor compositor;

    @ManyToOne
    @JoinColumn(name = "IDGENEROOBRAFKO", nullable = false)
    private GeneroObra generoObra;

    @ManyToOne
    @JoinColumn(name = "IDPERIODOFKO")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "CODPAISFKO", nullable = false)
    private Pais pais;

    @Column(name = "FECHAOBRA", nullable = false)
    private LocalDate fechaObra;

    @Column(name = "TITULO", nullable = false, length = 30)
    private String titulo;

    @Column(name = "ESTADO", nullable = false)
    private int estado;

    @OneToMany(mappedBy = "obra")
    private Set<Calendario> calendarios;

    @OneToMany(mappedBy = "obra")
    private Set<ObraInstrumento> obraInstrumentos;

    @OneToMany(mappedBy = "obra")
    private Set<ConvocatoriaEstudiante> convocatorias;

    @OneToMany(mappedBy = "obra")
    private Set<PersonalObra> personalObras;

    @OneToMany(mappedBy = "obra")
    private Set<GastoObra> gastoObra;
}
