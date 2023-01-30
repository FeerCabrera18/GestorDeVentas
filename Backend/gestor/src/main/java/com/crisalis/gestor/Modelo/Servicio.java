package com.crisalis.gestor.Modelo;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @SequenceGenerator(
            name = "secuencia_servicio",
            sequenceName = "secuencia_servicio",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia_servicio"
    )
    private Long id;
    @Column(name = "servicio")
    private String servicio;
    @Column(name = "precio")
    private BigDecimal precio;
}
