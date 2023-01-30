package com.crisalis.gestor.Servicio.impl;

import com.crisalis.gestor.Modelo.Producto;
import com.crisalis.gestor.Modelo.Servicio;
import com.crisalis.gestor.Repositorio.ServicioRepositorio;
import com.crisalis.gestor.Servicio.ServServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServServicioImpl implements ServServicio {
    private ServicioRepositorio servicioRepositorio;
    @Override
    public Servicio crearServicio(Servicio servicio) {
        return servicioRepositorio.save(servicio);
    }
    @Override
    public Servicio obtenerServicioById(Long id) {
        Servicio optionalServicio = servicioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe servicio con ese id"));
        return optionalServicio;
    }
    @Override
    public List<Servicio> obtenerLista() {
        return servicioRepositorio.findAll();
    }
    @Override
    public Servicio actualizarServicio(Servicio servicio) {
        Servicio servicioExistente = servicioRepositorio.findById(servicio.getId()).get();
        servicioExistente.setServicio(servicio.getServicio());
        servicioExistente.setPrecio(servicio.getPrecio());
        return servicioRepositorio.save(servicioExistente);
    }
    @Override
    public void borrarServicio(Long id) {
        servicioRepositorio.deleteById(id);
    }
}
