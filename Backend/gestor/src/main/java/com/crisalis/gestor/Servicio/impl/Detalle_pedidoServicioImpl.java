package com.crisalis.gestor.Servicio.impl;

import com.crisalis.gestor.Modelo.Detalle_pedido;
import com.crisalis.gestor.Repositorio.Detalle_pedidoRepositorio;
import com.crisalis.gestor.Servicio.Detalle_pedidoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Detalle_pedidoServicioImpl implements Detalle_pedidoServicio {
    private Detalle_pedidoRepositorio detalle_pedidoRepositorio;
    @Override
    public Detalle_pedido crearDetalle_pedido(Detalle_pedido detalle_pedido) {
        return detalle_pedidoRepositorio.save(detalle_pedido);
    }

    @Override
    public Detalle_pedido obtenerDetalle_pedidoById(Long id) {
        Detalle_pedido optionalDetalle_pedido = detalle_pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe detalle de pedido con ese id"));
        return optionalDetalle_pedido;
    }

    @Override
    public List<Detalle_pedido> obtenerLista() {
        return detalle_pedidoRepositorio.findAll();
    }

    @Override
    public Detalle_pedido actualizarDetalle_pedido(Detalle_pedido detalle_pedido) {
        Detalle_pedido detalle_pedidoExistente = detalle_pedidoRepositorio.findById(detalle_pedido.getId()).get();
        detalle_pedidoExistente.setCantidad(detalle_pedido.getCantidad());
        detalle_pedidoExistente.setPrecio_venta(detalle_pedido.getPrecio_venta());
        detalle_pedidoExistente.setSubtotal(detalle_pedido.getSubtotal());
        detalle_pedidoExistente.setProducto(detalle_pedido.getProducto());
        detalle_pedidoExistente.setServicio(detalle_pedido.getServicio());
        return detalle_pedidoRepositorio.save(detalle_pedidoExistente);
    }

    @Override
    public void borrarDetalle_pedido(Long id) {
        detalle_pedidoRepositorio.deleteById(id);
    }
}
