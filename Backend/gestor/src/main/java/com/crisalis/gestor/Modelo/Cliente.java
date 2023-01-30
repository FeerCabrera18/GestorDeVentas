package com.crisalis.gestor.Modelo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @SequenceGenerator(
            name = "secuencia_cliente",
            sequenceName = "secuencia_cliente",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia_cliente"
    )
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private String dni;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "Empresa")
    private boolean Empresa;
    @Column(name = "cuit")
    private String cuit;
    @Column(name = "razon_social")
    private String razon_social;
    @Column(name = "fecha_inicio")
    private LocalDate fecha_inicio;
}
