package com.crisalis.gestor.Excepcion.personalizado;

public class ErrorCrearUsuario extends RuntimeException{
    private static final String Descripcion = "Error al crear usuario";

    public ErrorCrearUsuario (String detalle){
        super(Descripcion + ", " + detalle);
    }
}