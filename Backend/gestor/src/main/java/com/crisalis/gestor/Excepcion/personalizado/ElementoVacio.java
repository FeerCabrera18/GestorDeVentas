package com.crisalis.gestor.Excepcion.personalizado;

public class ElementoVacio extends RuntimeException{

    private static final String Descripcion = "Elemento vacio";

    public ElementoVacio (String detalle){
        super(Descripcion + ", " + detalle);
    }
}
