package com.crisalis.gestor.Excepcion.personalizado;

public class CredencialInvalida extends RuntimeException{
        private static final String DESCRIPTION = "Credencial Invalida";

        public CredencialInvalida(String detail) {
            super(DESCRIPTION + ", " + detail);
        }
}
