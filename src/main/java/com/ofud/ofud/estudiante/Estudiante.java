package com.ofud.ofud.estudiante;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    @Id
    @Column(nullable = false, length = 11)
    private long codigo;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String apellido;
    
    private LocalDate nacimiento;

    @Column(nullable = false, length = 12)
    private long documento;

    @Column(nullable = false, length = 2)
    private String tipo;

    @Column(nullable = false, length = 30)
    private String correoPersonal;

    @Column(nullable = false, length = 30)
    private String correoInstitucional;

    @Column(nullable = false, length = 10)
    private long celular;

}
