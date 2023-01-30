package com.crisalis.gestor.Servicio.impl;

import com.crisalis.gestor.Modelo.Cliente;
import com.crisalis.gestor.Modelo.Detalle_pedido;
import com.crisalis.gestor.Repositorio.ClienteRepositorio;
import com.crisalis.gestor.Servicio.ClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServicioImpl implements ClienteServicio {
    private ClienteRepositorio clienteRepositorio;
    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }
    @Override
    public Cliente obtenerClienteById(Long id) {
        Cliente optionalCliente = clienteRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe cliente con ese id"));
        return optionalCliente;
    }
    @Override
    public List<Cliente> obtenerLista() {
        return clienteRepositorio.findAll();
    }
    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        Cliente clienteExistente = clienteRepositorio.findById(cliente.getId()).get();
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setDni(cliente.getDni());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setEmpresa(cliente.isEmpresa());
        clienteExistente.setCuit(cliente.getCuit());
        clienteExistente.setRazon_social(cliente.getRazon_social());
        clienteExistente.setFecha_inicio(cliente.getFecha_inicio());
        return clienteRepositorio.save(clienteExistente);
    }
    @Override
    public void borrarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }
}
