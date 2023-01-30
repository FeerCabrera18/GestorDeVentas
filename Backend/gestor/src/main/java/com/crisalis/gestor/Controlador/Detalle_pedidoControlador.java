package com.crisalis.gestor.Controlador;

import com.crisalis.gestor.Modelo.Detalle_pedido;
import com.crisalis.gestor.Servicio.Detalle_pedidoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("detalle_pedido")
public class Detalle_pedidoControlador {
    private Detalle_pedidoServicio detalle_pedidoServicio;
    @PostMapping(value = "crearDetalle_pedido")
    public ResponseEntity<Detalle_pedido> crearDetalle_pedido(@RequestBody Detalle_pedido detalle_pedido){
        Detalle_pedido crearDetalle_pedido= detalle_pedidoServicio.crearDetalle_pedido(detalle_pedido);
        return new ResponseEntity<>(crearDetalle_pedido, HttpStatus.CREATED);
    }
    @GetMapping(value = "obtenerDetalle_pedidoById/{id}")
    public ResponseEntity<Detalle_pedido> obtenerDetalle_pedidoById(@PathVariable("id") Long id){
        Detalle_pedido detalle_pedido = detalle_pedidoServicio.obtenerDetalle_pedidoById(id);
        return new ResponseEntity<>(detalle_pedido, HttpStatus.OK);
    }
    @GetMapping(value = "listaDetalle_pedido")
    public ResponseEntity<List<Detalle_pedido>> obtenerLista(){
        List<Detalle_pedido> detalle_pedidos = detalle_pedidoServicio.obtenerLista();
        return new ResponseEntity<>(detalle_pedidos, HttpStatus.OK);
    }
    @PutMapping(value = "actualizarDetalle_pedido/{id}")
    public ResponseEntity<Detalle_pedido> actualizarProducto(@PathVariable("id") Long id,
                                                       @RequestBody Detalle_pedido detalle_pedido){
        detalle_pedido.setId(id);
        Detalle_pedido actualizarDetalle_pedido = detalle_pedidoServicio.actualizarDetalle_pedido(detalle_pedido);
        return new ResponseEntity<>(actualizarDetalle_pedido, HttpStatus.OK);
    }
    @DeleteMapping(value = "borrarDetalle_pedido/{id}")
    public ResponseEntity<String> borrarDetalle_pedido(@PathVariable("id") Long id){
        detalle_pedidoServicio.borrarDetalle_pedido(id);
        return new ResponseEntity<>("Detalle pedido eliminado!", HttpStatus.OK);
    }
}
