package com.crisalis.gestor.Servicio;

import com.crisalis.gestor.Modelo.Pedido;
import java.util.List;

public interface PedidoServicio {
    Pedido crearPedido(Pedido pedido);
    Pedido obtenerPedidoById(Long id);
    List<Pedido> obtenerLista();
    Pedido actualizarPedido(Pedido pedido, Long id);
    void borrarPedido(Long id);
}
