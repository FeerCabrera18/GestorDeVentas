package com.crisalis.gestor.Repositorio;

import com.crisalis.gestor.Modelo.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpuestosRespositorio extends JpaRepository<Impuesto, Long> {
}
