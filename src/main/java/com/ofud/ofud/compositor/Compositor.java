package com.ofud.ofud.compositor;

import java.util.Set;

import com.ofud.ofud.obra.Obra;
import com.ofud.ofud.pais.Pais;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "COMPOSITOR")
@Data
public class Compositor {

    @Id
    @Column(name = "IDCOMPOSITOR", nullable = false, length = 3)
    private String idCompositor;

    @ManyToOne
    @JoinColumn(name = "CODPAISFKC", nullable = false)
    private Pais pais;

    @Column(name = "NOMCOMPOSITOR", nullable = false, length = 30)
    private String nombreCompositor;

    @OneToMany(mappedBy = "compositor")
    private Set<Obra> obras;

}
