package com.examen.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.truper.entities.Ordenes;


public interface OrdenDeCompraRepository extends JpaRepository<Ordenes, Long> {

}
