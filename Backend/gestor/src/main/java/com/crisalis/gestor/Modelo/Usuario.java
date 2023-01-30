package com.crisalis.gestor.Modelo;

import com.crisalis.gestor.Modelo.dto.UsuarioDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @SequenceGenerator(
            name = "secuencia_usuario",
            sequenceName = "secuencia_usuario",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia_usuario"
    )
    @Column(name = "Id")
    private Integer Id;
    @Column(name = "Usuario")
    private String username;
    @Column(name = "Contraseña")
    private String password;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;

    public Usuario(UsuarioDTO usuarioDTO){
        this.nombre = usuarioDTO.getNombre();
        this.apellido = usuarioDTO.getApellido();
        this.username = usuarioDTO.getUsername();
        this.password = usuarioDTO.getPassword();
    }
    public UsuarioDTO toDTO() {
        return
                UsuarioDTO.builder()
                        .nombre(this.nombre)
                        .apellido(this.apellido)
                        .username(this.username)
                        .password(this.password)
                        .build();
    }
}
