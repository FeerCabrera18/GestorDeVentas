package com.crisalis.gestor.Excepcion;

import com.crisalis.gestor.Excepcion.personalizado.CredencialInvalida;
import com.crisalis.gestor.Excepcion.personalizado.ElementoVacio;
import com.crisalis.gestor.Excepcion.personalizado.ErrorCrearUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManejadorExcepciones {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            ElementoVacio.class,
            ErrorCrearUsuario.class
    })
    @ResponseBody
    public MensajeError errorSolicitud(HttpServletRequest request, Exception exception) {
        return new MensajeError(exception, request.getRequestURI());
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({
            CredencialInvalida.class
    })
    @ResponseBody
    public void unauthorized() {
    }
}