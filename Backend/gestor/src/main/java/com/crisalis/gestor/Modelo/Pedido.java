package com.crisalis.gestor.Modelo;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @SequenceGenerator(
            name = "pedido_secuencia",
            sequenceName = "pedido_secuencia",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pedido_secuencia"
    )
    private Long id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "total_pedido")
    private BigDecimal total_pedido;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE
    )
    List<Detalle_pedido> detalle_pedidos;
}
