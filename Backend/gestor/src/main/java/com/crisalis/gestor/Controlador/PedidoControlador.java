package com.crisalis.gestor.Controlador;

import com.crisalis.gestor.Modelo.Pedido;
import com.crisalis.gestor.Servicio.PedidoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("pedido")
public class PedidoControlador {
    private PedidoServicio pedidoServicio;
    @PostMapping(value = "crearPedido")
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido){
        Pedido crearPedido = pedidoServicio.crearPedido(pedido);
        return new ResponseEntity<>(crearPedido, HttpStatus.CREATED);
    }
    @GetMapping(value = "obtenerPedidoById/{id}")
    public ResponseEntity<Pedido> obtenerPedidoById(@PathVariable("id") Long id){
        Pedido pedido = pedidoServicio.obtenerPedidoById(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
    @GetMapping(value = "listaPedidos")
    public ResponseEntity<List<Pedido>> obtenerLista(){
        List<Pedido> pedidos = pedidoServicio.obtenerLista();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    @PutMapping(value = "actualizarPedido/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable("id") Long id,
                                                       @RequestBody Pedido pedido){
        pedido.setId(id);
        Pedido actualizarPedido = pedidoServicio.actualizarPedido(pedido, id);
        return new ResponseEntity<>(actualizarPedido, HttpStatus.OK);
    }
    @DeleteMapping(value = "borrarPedido/{id}")
    public ResponseEntity<String> borrarPedido(@PathVariable("id") Long id){
        pedidoServicio.borrarPedido(id);
        return new ResponseEntity<>("Pedido eliminado!", HttpStatus.OK);
    }
}
