package com.crisalis.gestor.Controlador;

import com.crisalis.gestor.Modelo.Cliente;
import com.crisalis.gestor.Modelo.Producto;
import com.crisalis.gestor.Servicio.ClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("clientes")
public class ClienteControlador {
    private ClienteServicio clienteServicio;
    @PostMapping(value = "crearCliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        Cliente crearCliente = clienteServicio.crearCliente(cliente);
        return new ResponseEntity<>(crearCliente, HttpStatus.CREATED);
    }
    @GetMapping(value = "obtenerClienteById/{id}")
    public ResponseEntity<Cliente> obtenerClienteById(@PathVariable("id") Long id){
        Cliente cliente = clienteServicio.obtenerClienteById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    @GetMapping(value = "listaClientes")
    public ResponseEntity<List<Cliente>> obtenerLista(){
        List<Cliente> clientes = clienteServicio.obtenerLista();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    @PutMapping(value = "actualizarCliente/{id}")
    public ResponseEntity<Cliente> actualizarProducto(@PathVariable("id") Long id,
                                                       @RequestBody Cliente cliente){
        cliente.setId(id);
        Cliente actualizarCliente = clienteServicio.actualizarCliente(cliente);
        return new ResponseEntity<>(actualizarCliente, HttpStatus.OK);
    }
    @DeleteMapping(value = "borrarCliente/{id}")
    public ResponseEntity<String> borrarCliente(@PathVariable("id") Long id){
        clienteServicio.borrarCliente(id);
        return new ResponseEntity<>("Cliente eliminado!", HttpStatus.OK);
    }

}
