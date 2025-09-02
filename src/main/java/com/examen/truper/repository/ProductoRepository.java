package com.examen.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.examen.truper.entities.Productos;

import jakarta.transaction.Transactional;

public interface ProductoRepository extends JpaRepository<Productos, Long>{

	@Transactional
	@Modifying
	@Query("UPDATE Productos pr SET pr.precio = ?2 WHERE pr.productoId = ?1")
	public void updatePrecioById(Long id, double precio);
}
