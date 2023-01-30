package com.crisalis.gestor.Repositorio;

import com.crisalis.gestor.Modelo.Detalle_pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_pedidoRepositorio extends JpaRepository<Detalle_pedido, Long> {
}
