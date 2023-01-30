package com.crisalis.gestor.Controlador;

import com.crisalis.gestor.Modelo.Producto;
import com.crisalis.gestor.Servicio.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("producto")
public class ProductoControlador {
    private ProductoServicio productoServicio;
    @PostMapping(value = "crearProducto")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        Producto crearProducto = productoServicio.crearProducto(producto);
        return new ResponseEntity<>(crearProducto, HttpStatus.CREATED);
    }
    @GetMapping(value = "obtenerProductoById/{id}")
    public ResponseEntity<Producto> obtenerProductoById(@PathVariable("id") Long id){
        Producto producto = productoServicio.obtenerProductoById(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
    @GetMapping(value = "listaProductos")
    public ResponseEntity<List<Producto>> obtenerLista(){
        List<Producto> productos = productoServicio.obtenerLista();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @PutMapping(value = "actualizarProducto/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Long id,
                                                       @RequestBody Producto producto){
        producto.setId(id);
        Producto actualizarProducto = productoServicio.actualizarProducto(producto);
        return new ResponseEntity<>(actualizarProducto, HttpStatus.OK);
    }
    @DeleteMapping(value = "borrarProducto/{id}")
    public ResponseEntity<String> borrarProducto(@PathVariable("id") Long id){
        productoServicio.borrarProducto(id);
        return new ResponseEntity<>("Producto eliminado!", HttpStatus.OK);
    }
}
