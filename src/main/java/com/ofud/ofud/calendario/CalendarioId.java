package com.ofud.ofud.calendario;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class CalendarioId implements Serializable{
    @Column(name = "CONSECALENDARIO", nullable = false)
    private int conseCalendario;

    private String obra;

    private String tipoCalen;
}
