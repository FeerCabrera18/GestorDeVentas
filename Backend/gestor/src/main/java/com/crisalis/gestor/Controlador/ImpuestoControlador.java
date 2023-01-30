package com.crisalis.gestor.Controlador;

import com.crisalis.gestor.Modelo.Impuesto;
import com.crisalis.gestor.Servicio.ImpuestosServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("impuestos")
public class ImpuestoControlador {
    private ImpuestosServicio impuestosServicio;
    @PostMapping(value = "crearImpuesto")
    public ResponseEntity<Impuesto> crearImpuestos(@RequestBody Impuesto impuesto){
        Impuesto crearImpuesto = impuestosServicio.crearImpuestos(impuesto);
        return new ResponseEntity<>(crearImpuesto, HttpStatus.CREATED);
    }
    @GetMapping(value = "obtenerImpuestoById/{id}")
    public ResponseEntity<Impuesto> obtenerImpuestosById(@PathVariable("id") Long id){
        Impuesto impuesto = impuestosServicio.obtenerImpuestosById(id);
        return new ResponseEntity<>(impuesto, HttpStatus.OK);
    }
    @GetMapping(value = "listaImpuestos")
    public ResponseEntity<List<Impuesto>> obtenerLista(){
        List<Impuesto> impuestoList = impuestosServicio.obtenerLista();
        return new ResponseEntity<>(impuestoList, HttpStatus.OK);
    }
    @PutMapping(value = "actualizarImpuestos/{id}")
    public ResponseEntity<Impuesto> actualizarImpuestos(@PathVariable("id") Long id,
                                                        @RequestBody Impuesto impuesto){
        impuesto.setId(id);
        Impuesto actualizarImpuesto = impuestosServicio.actualizarImpuestos(impuesto);
        return new ResponseEntity<>(actualizarImpuesto, HttpStatus.OK);
    }
    @DeleteMapping(value = "borrarImpuestos/{id}")
    public ResponseEntity<String> borrarImpuestos(@PathVariable("id") Long id){
        impuestosServicio.borrarImpuestos(id);
        return new ResponseEntity<>("Impuesto eliminado!", HttpStatus.OK);
    }
}
