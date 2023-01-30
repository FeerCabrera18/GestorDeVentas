package com.crisalis.gestor.Servicio;

import com.crisalis.gestor.Modelo.Producto;
import com.crisalis.gestor.Modelo.Servicio;

import java.util.List;

public interface ServServicio {
    Servicio crearServicio(Servicio servicio);
    Servicio obtenerServicioById(Long id);
    List<Servicio> obtenerLista();
    Servicio actualizarServicio(Servicio servicio);
    void borrarServicio(Long id);
}
