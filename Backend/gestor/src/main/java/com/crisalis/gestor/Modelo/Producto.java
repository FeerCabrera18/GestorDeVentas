package com.crisalis.gestor.Modelo;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @SequenceGenerator(
            name = "secuencia_producto",
            sequenceName = "secuencia_producto",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia_producto"
    )
    private Long id;
    @Column(name = "producto")
    private String producto;
    @Column(name = "precio")
    private BigDecimal precio;

    /*@OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE
    )
    List<Impuesto> impuestos;*/
}
