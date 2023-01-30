package com.crisalis.gestor.Modelo;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class Detalle_pedido {
    @Id
    @SequenceGenerator(
            name = "detalle_pedido_secuencia",
            sequenceName = "detalle_pedido_secuencia",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "detalle_pedido_secuencia"
    )
    private Long id;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio_unitario")
    private BigDecimal precio_unitario;
    @Column(name = "sub_total")
    private BigDecimal sub_total;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
}
