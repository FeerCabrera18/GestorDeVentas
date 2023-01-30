package com.crisalis.gestor.Servicio;

import com.crisalis.gestor.Modelo.Producto;

import java.util.List;

public interface ProductoServicio {
    Producto crearProducto(Producto producto);
    Producto obtenerProductoById(Long id);
    List<Producto> obtenerLista();
    Producto actualizarProducto(Producto producto);
    void borrarProducto(Long id);
}
