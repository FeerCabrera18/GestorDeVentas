package com.crisalis.gestor.Servicio.impl;

import com.crisalis.gestor.Modelo.Pedido;
import com.crisalis.gestor.Repositorio.PedidoRepositorio;
import com.crisalis.gestor.Servicio.PedidoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoServicioImpl implements PedidoServicio {
    private PedidoRepositorio pedidoRepositorio;
    @Override
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }
    @Override
    public Pedido obtenerPedidoById(Long id) {
        Pedido optionalPedido = pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe pedido con ese id"));
        return optionalPedido;
    }
    @Override
    public List<Pedido> obtenerLista() {
        return pedidoRepositorio.findAll();
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido, Long id) {
        Pedido pedidoExistente = pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe pedido con ese id"));
        pedidoExistente.setFecha(pedido.getFecha());
        pedidoExistente.setNro_comprobante(pedido.getNro_comprobante());
        pedidoExistente.setEmpresa_emisora(pedido.getEmpresa_emisora());
        pedidoExistente.setTotal_pedido(pedido.getTotal_pedido());
        pedidoExistente.setCliente(pedido.getCliente());
        return pedidoRepositorio.save(pedidoExistente);
    }
    @Override
    public void borrarPedido(Long id) {
        pedidoRepositorio.deleteById(id);
    }
}
