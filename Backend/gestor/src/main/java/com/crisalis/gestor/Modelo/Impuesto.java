package com.crisalis.gestor.Modelo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "impuesto")
public class Impuesto {
    @Id
    @SequenceGenerator(
            name = "secuencia_impuesto",
            sequenceName = "secuencia_impuesto",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia_impuesto"
    )
    private Long id;
    @Column(name = "nombre_impuesto")
    private String nombre_impuesto;
    @Column(name = "porcentaje")
    private double porcentaje;
}
