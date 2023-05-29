package com.ofud.ofud.pais;

import java.util.Set;

import com.ofud.ofud.compositor.Compositor;
import com.ofud.ofud.obra.Obra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAIS")
public class Pais {

    @Id
    @Column(name = "CODPAIS", nullable = false, length = 3)
    private String codigoPais;

    @Column(name = "NOMPAIS", nullable = false, length = 30)
    private String nombrePais;

    @OneToMany(mappedBy = "pais")
    private Set<Obra> obras;
    
    @OneToMany(mappedBy = "pais")
    private Set<Compositor> compositores;

}
