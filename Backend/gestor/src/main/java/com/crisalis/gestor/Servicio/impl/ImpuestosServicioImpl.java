package com.crisalis.gestor.Servicio.impl;

import com.crisalis.gestor.Modelo.Impuesto;
import com.crisalis.gestor.Repositorio.ImpuestosRespositorio;
import com.crisalis.gestor.Servicio.ImpuestosServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImpuestosServicioImpl implements ImpuestosServicio {
    private ImpuestosRespositorio  impuestosRespositorio;
    @Override
    public Impuesto crearImpuestos(Impuesto impuesto) {
        return impuestosRespositorio.save(impuesto);
    }
    @Override
    public Impuesto obtenerImpuestosById(Long id) {
        Impuesto optionalImpuestos = impuestosRespositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe impuesto con ese id"));
        return optionalImpuestos;
    }
    @Override
    public List<Impuesto> obtenerLista() {
        return impuestosRespositorio.findAll();
    }
    @Override
    public Impuesto actualizarImpuestos(Impuesto impuesto) {
        Impuesto impuestoExistente = impuestosRespositorio.findById(impuesto.getId()).get();
        impuestoExistente.setNombre_impuesto(impuesto.getNombre_impuesto());
        impuestoExistente.setPorcentaje(impuesto.getPorcentaje());
        return impuestosRespositorio.save(impuestoExistente);
    }
    @Override
    public void borrarImpuestos(Long id) {
        impuestosRespositorio.deleteById(id);
    }
}
