package com.ofud.ofud.generoObra;

import java.util.Set;

import com.ofud.ofud.obra.Obra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "GENEROOBRA")
@Data
public class GeneroObra {

    @Id
    @Column(name = "IDGENEROOBRA", nullable = false, length = 2)
    private String idGeneroObra;

    @Column(name = "DESCGENERO", nullable = false, length = 30)
    private String descripcionGenero;

    @OneToMany(mappedBy = "generoObra")
    private Set<Obra> obras;
}
