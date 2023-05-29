package com.ofud.ofud.estudiante;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofud.ofud.ConvocatoriaEstudiante.ConvocatoriaEstudiante;
import com.ofud.ofud.participacionEstudiante.ParticipacionEstudiante;
import com.ofud.ofud.unidad.Unidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(name = "CODESTUDIANTE", nullable = false, length = 10)
    private String codigoEstudiante;

    @ManyToOne
    @JoinColumn(name = "CODUNIDADFKE", nullable = false)
    private Unidad unidad;

    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 30)
    private String apellido;

    @Column(name = "FECHAINSCRIPCION", nullable = false)
    private LocalDate fechaInscripcion;

    @Column(name = "FECHANACIMIENTO", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "CORREO", nullable = false, length = 40)
    private String correo;

    @JsonIgnore
    @OneToMany(mappedBy = "estudiante")
    private Set<ConvocatoriaEstudiante> convocatorias;

    @JsonIgnore
    @OneToMany(mappedBy = "estudiante")
    private Set<ParticipacionEstudiante> participaciones;

}
