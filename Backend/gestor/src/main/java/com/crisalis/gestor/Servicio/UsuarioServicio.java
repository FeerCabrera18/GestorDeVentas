package com.crisalis.gestor.Servicio;

import com.crisalis.gestor.Excepcion.personalizado.CredencialInvalida;
import org.apache.commons.lang3.StringUtils;
import com.crisalis.gestor.Excepcion.personalizado.ElementoVacio;
import com.crisalis.gestor.Excepcion.personalizado.ErrorCrearUsuario;
import com.crisalis.gestor.Modelo.Usuario;
import com.crisalis.gestor.Modelo.dto.UsuarioDTO;
import com.crisalis.gestor.Repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicio {
    private final UsuarioRepositorio usuarioRepositorio;
    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }
    public Usuario guardarUsuario (UsuarioDTO usuarioDTO){
        if(comprobarDTO(usuarioDTO, false)){
            return this.usuarioRepositorio.save(new Usuario(usuarioDTO));
        }
        throw new ErrorCrearUsuario("Error al guardar usuario");
    }
    public UsuarioDTO iniciarSesion(String username, String password) {
        if(this.comprobarDTO(UsuarioDTO
                .builder()
                .username(username)
                .password(password)
                .build(), true)
        ) {
            return this.usuarioRepositorio.findByUsernameAndPassword(username, password)
                    .orElseThrow(
                            () -> new CredencialInvalida("Credencial invalida")
                    ).toDTO();
        }
        throw new CredencialInvalida("Credencial invalida");
    }
    public List<UsuarioDTO> getListAllUsersInDB() {
        return this.usuarioRepositorio
                .findAll()
                .stream()
                .map(Usuario::toDTO)
                .collect(Collectors.toList());
    }
    private boolean comprobarDTO(UsuarioDTO usuarioDTO, boolean InicioSesion){
        if(!InicioSesion){
            if(StringUtils.isEmpty (usuarioDTO.getNombre())){
                throw new ElementoVacio("nombre vacio");
            }
            if(StringUtils.isEmpty (usuarioDTO.getApellido())){
                throw new ElementoVacio("apellido vacio");
            }
        }
        if(StringUtils.isEmpty (usuarioDTO.getUsername())){
            throw new ElementoVacio("usuario vacio");
        }
        if(StringUtils.isEmpty (usuarioDTO.getPassword())){
            throw new ElementoVacio("contraseña vacio");
        }
        return true;
    }
}
