package com.ofud.ofud.tipoCalendario;

import java.util.Set;

import com.ofud.ofud.calendario.Calendario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TIPOCALENDARIO")
@Data
public class TipoCalendario {
    @Id
    @Column(name = "IDTIPOCALEN", nullable = false, length = 2)
    private String id;

    @Column(name = "DESCTIPOCALENDARIO", nullable = false, length = 40)
    private String desc;

    @OneToMany(mappedBy = "tipoCalen")
    private Set<Calendario> calendarios;
}
