package com.crisalis.gestor.Servicio;

import com.crisalis.gestor.Modelo.Detalle_pedido;

import java.util.List;

public interface Detalle_pedidoServicio {
    Detalle_pedido crearDetalle_pedido(Detalle_pedido detalle_pedido);
    Detalle_pedido obtenerDetalle_pedidoById(Long id);
    List<Detalle_pedido> obtenerLista();
    Detalle_pedido actualizarDetalle_pedido(Detalle_pedido detalle_pedido);
    void borrarDetalle_pedido(Long id);
}
