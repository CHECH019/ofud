package com.ofud.ofud.estado;

import java.util.Set;

import com.ofud.ofud.calendario.Calendario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ESTADO")
@Data
public class Estado {
    @Id
    @Column(name = "IDESTADO", nullable = false, length = 10)
    private String id;

    @OneToMany(mappedBy = "estado")
    private Set<Calendario> calendarios;
}
