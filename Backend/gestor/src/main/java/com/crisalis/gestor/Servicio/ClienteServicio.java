package com.crisalis.gestor.Servicio;

import com.crisalis.gestor.Modelo.Cliente;
import com.crisalis.gestor.Modelo.Producto;

import java.util.List;

public interface ClienteServicio {
    Cliente crearCliente(Cliente cliente);
    Cliente obtenerClienteById(Long id);
    List<Cliente> obtenerLista();
    Cliente actualizarCliente(Cliente cliente);
    void borrarCliente(Long id);
}
