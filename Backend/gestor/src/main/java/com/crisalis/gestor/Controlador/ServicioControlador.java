package com.crisalis.gestor.Controlador;

import com.crisalis.gestor.Modelo.Servicio;
import com.crisalis.gestor.Servicio.ServServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("servicio")
public class ServicioControlador {
    private ServServicio servServicio;
    @PostMapping(value = "crearServicio")
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio){
        Servicio crearServicio = servServicio.crearServicio(servicio);
        return new ResponseEntity<>(crearServicio, HttpStatus.CREATED);
    }
    @GetMapping(value = "obtenerServicioById/{id}")
    public ResponseEntity<Servicio> obtenerServicioById(@PathVariable("id") Long id){
        Servicio servicio = servServicio.obtenerServicioById(id);
        return new ResponseEntity<>(servicio, HttpStatus.OK);
    }
    @GetMapping(value = "listaServicios")
    public ResponseEntity<List<Servicio>> obtenerLista(){
        List<Servicio> servicios = servServicio.obtenerLista();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }
    @PutMapping(value = "actualizarServicio/{id}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable("id") Long id,
                                                       @RequestBody Servicio servicio){
        servicio.setId(id);
        Servicio actualizarServicio = servServicio.actualizarServicio(servicio);
        return new ResponseEntity<>(actualizarServicio, HttpStatus.OK);
    }
    @DeleteMapping(value = "borrarServicio/{id}")
    public ResponseEntity<String> borrarServicio(@PathVariable("id") Long id){
        servServicio.borrarServicio(id);
        return new ResponseEntity<>("Servicio eliminado!", HttpStatus.OK);
    }
}
