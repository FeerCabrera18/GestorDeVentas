package com.crisalis.gestor.Servicio.impl;

import com.crisalis.gestor.Modelo.Producto;
import com.crisalis.gestor.Repositorio.ProductoRepositorio;
import com.crisalis.gestor.Servicio.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {
    private ProductoRepositorio productoRepositorio;
    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }
    @Override
    public Producto obtenerProductoById(Long id) {
        Producto optionalProducto = productoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe producto con ese id"));
        return optionalProducto;
    }
    @Override
    public List<Producto> obtenerLista() {
        return productoRepositorio.findAll();
    }
    @Override
    public Producto actualizarProducto(Producto producto) {
        Producto productoExistente = productoRepositorio.findById(producto.getId()).get();
        productoExistente.setProducto(producto.getProducto());
        productoExistente.setPrecio(producto.getPrecio());
        return productoRepositorio.save(productoExistente);
    }
    @Override
    public void borrarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }
}
