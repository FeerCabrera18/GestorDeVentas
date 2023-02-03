package com.crisalis.gestor.Modelo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {
    @JsonProperty("Nombre")
    private String nombre;
    @JsonProperty("Apellido")
    private String apellido;
    @JsonProperty("Usuario")
    private String username;
    @JsonProperty("Contraseña")
    private String password;
}
