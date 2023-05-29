package com.ofud.ofud.calendario;

import java.time.LocalDateTime;
import java.util.Set;

import com.ofud.ofud.LaborPersonalObra.LaborPersonalObra;
import com.ofud.ofud.estado.Estado;
import com.ofud.ofud.obra.Obra;
import com.ofud.ofud.participacionEstudiante.ParticipacionEstudiante;
import com.ofud.ofud.tipoCalendario.TipoCalendario;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table
@Data
public class Calendario {
    @EmbeddedId
    private CalendarioId calendarioId;

    @MapsId("obra")
    @ManyToOne
    @JoinColumn(name = "IDOBRAFKCA", nullable = false)
    private Obra obra;

    @MapsId("tipoCalen")
    @ManyToOne
    @JoinColumn(name = "IDTIPOCALENFKC", nullable = false)
    private TipoCalendario tipoCalen;

    @ManyToOne
    @JoinColumn(name = "IDESTADOFKC", nullable = false)
    private Estado estado;

    @Column(name = "FECHAINICIO", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "FECHAFIN", nullable = false)
    private LocalDateTime fechaFin;

    @OneToMany(mappedBy = "calendario")
    private Set<ParticipacionEstudiante> participaciones;

    @OneToMany(mappedBy = "calendario")
    private Set<LaborPersonalObra> laborPersonalObras;
}
