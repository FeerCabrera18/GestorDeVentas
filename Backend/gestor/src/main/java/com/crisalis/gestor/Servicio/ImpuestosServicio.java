package com.crisalis.gestor.Servicio;

import com.crisalis.gestor.Modelo.Impuesto;

import java.util.List;

public interface ImpuestosServicio {
    Impuesto crearImpuestos(Impuesto impuesto);
    Impuesto obtenerImpuestosById(Long id);
    List<Impuesto> obtenerLista();
    Impuesto actualizarImpuestos(Impuesto impuesto);
    void borrarImpuestos(Long id);
}
